package gis;

import java.net.*;
import org.jgrapht.graph.*;

public class Main {
	
	public static SimpleDirectedWeightedGraph<Integer, DefaultWeightedEdge> graph = new SimpleDirectedWeightedGraph<>(
			DefaultWeightedEdge.class);

	public static void main(String[] args) {
		GraphParser.ParseFileToGraph(graph);
		System.out.println(graph.toString());

		Path minPath = PathResolver.FindMinWidthPath(graph, 0, 3);
		Path maxPath = PathResolver.FindMaxWidthPath(graph, 0, 3);

		System.out.println("Min: " + minPath);
		System.out.println("Max: " + maxPath);
	}

}
