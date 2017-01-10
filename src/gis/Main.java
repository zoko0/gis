package gis;

import org.jgrapht.graph.*;

public class Main {

	public static void main(String[] args) {
		// graf z pliku

		// "2w3k_petla.txt" - petle zabronione
		
		String[] testFiles = new String[] {"1w.txt", "2w2k.txt", "2w1k.txt", "drzewo.txt",
				"mostek.txt", "sciezka.txt", "test.txt", "test1.txt" };

		for (String file : testFiles) {
			System.out.println();
			System.out.println(file);
			System.out.println();

			SimpleDirectedWeightedGraph<Integer, DefaultWeightedEdge> graph = new SimpleDirectedWeightedGraph<>(
						DefaultWeightedEdge.class);
			GraphParser.ParseFileToGraph(graph, file);

			// losowo generowany graf
			// int verticesCount = 50;
			// double probabilityOfEdge = 0.8;
			// SimpleGraphGenerator.doGenerate(graph, verticesCount,
			// probabilityOfEdge);

			System.out.println(graph.toString());

			Path minPath = PathResolver.FindMinWidthPath(graph, 0, graph.vertexSet().size() - 1);
			Path maxPath = PathResolver.FindMaxWidthPath(graph, 0, graph.vertexSet().size() - 1);

			System.out.println("Min: " + minPath);
			System.out.println("Max: " + maxPath);
		}
	}

}
