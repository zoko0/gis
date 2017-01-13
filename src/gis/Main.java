package gis;

import org.jgrapht.graph.*;

public class Main {

	public static void main(String[] args) {
		
		// grafy z plików (pliki w folderze ./test/input/)
				
		String[] testFiles = new String[] {"1w.txt", "2w2k.txt", "2w1k.txt", "drzewo.txt",
				"mostek.txt", "sciezka.txt", "test.txt", "test_simple.txt"};
		
		for (String file : testFiles) {
			System.out.println();
			System.out.println(file);
			System.out.println();

			SimpleDirectedWeightedGraph<Integer, DefaultWeightedEdge> graph = new SimpleDirectedWeightedGraph<>(
						DefaultWeightedEdge.class);
			GraphParser.ParseFileToGraph(graph, file);


			System.out.println(graph.toString());

			Path minPath = PathResolver.FindMinWidthPath(graph, 0, graph.vertexSet().size() - 1);
			Path maxPath = PathResolver.FindMaxWidthPath(graph, 0, graph.vertexSet().size() - 1);

			System.out.println("Min: " + minPath);
			System.out.println("Max: " + maxPath);
		}
		
		// losowo generowany graf
		
		long startTime = System.nanoTime();
		
		SimpleDirectedWeightedGraph<Integer, DefaultWeightedEdge> graph = new SimpleDirectedWeightedGraph<>(
				DefaultWeightedEdge.class);
		int verticesCount = 1000;
		double probabilityOfEdge = 1.1;
		SimpleGraphGenerator.doGenerate(graph, verticesCount, probabilityOfEdge);

		System.out.println();
		System.out.println("Random generated graph");

		Path minPath = PathResolver.FindMinWidthPath(graph, 0, graph.vertexSet().size() - 1);
		Path maxPath = PathResolver.FindMaxWidthPath(graph, 0, graph.vertexSet().size() - 1);

		System.out.println("Min: " + minPath);
		System.out.println("Max: " + maxPath);
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns"); 
		
	}

}
