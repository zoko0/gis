package gis;

import org.jgrapht.graph.*;

public class Main {
	public static SimpleDirectedWeightedGraph <Integer, DefaultWeightedEdge> graph = new SimpleDirectedWeightedGraph <>(DefaultWeightedEdge.class);
	public static void main(String[] args) {
		//graf z pliku
		//GraphParser.ParseFileToGraph(graph);
		
		//losowo generowany graf
		int verticesCount = 50;
	    double probabilityOfEdge = 0.8;
	    SimpleGraphGenerator.doGenerate(graph, verticesCount, probabilityOfEdge);
	    
		
	    
		System.out.println(graph.toString());

	}

}
