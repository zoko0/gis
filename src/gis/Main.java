package gis;

import java.net.*;
import org.jgrapht.*;
import org.jgrapht.graph.*;

public class Main {
	public static SimpleDirectedWeightedGraph <Integer, DefaultWeightedEdge> graph = new SimpleDirectedWeightedGraph <>(DefaultWeightedEdge.class);
	public static void main(String[] args) {
		GraphParser.ParseFileToGraph(graph);
		System.out.println(graph.toString());

	}

}
