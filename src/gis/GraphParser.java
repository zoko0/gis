package gis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.jgrapht.graph.*;

public class GraphParser {
	public static void ParseFileToGraph(SimpleDirectedWeightedGraph<Integer, DefaultWeightedEdge> lGraph,
			String fileName) {

		String directory = "test/input/";
		String filePath = directory + fileName;

		String line;
		Integer numOfVertex, numOfEdges;

		// dodanie wierzcholkow do grafu
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			line = br.readLine(); // przeczytaj pierwsza linie
			String[] lineParts = line.split(",");

			numOfVertex = Integer.parseInt(lineParts[0]);
			numOfEdges = Integer.parseInt(lineParts[1]);

			for (int j = 0; j < numOfVertex; j++)
				lGraph.addVertex(j); // dodaj wierzcholki

			// dodanie lukow/krawedzi do grafu
			while ((line = br.readLine()) != null) {
				String[] edgeVars = line.split(",");

				System.out.println(edgeVars[0] + edgeVars[1] + edgeVars[2]);
				int source = Integer.parseInt(edgeVars[0]);
				int target = Integer.parseInt(edgeVars[1]);
				int weight = Integer.parseInt(edgeVars[2]);

				DefaultWeightedEdge edge = lGraph.addEdge(source, target); // zrodlo,cel
				lGraph.setEdgeWeight(edge, Double.valueOf(weight)); // dodanie
																	// wagi do
																	// krawedzi
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
