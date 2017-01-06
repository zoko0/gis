package gis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.*;
import org.jgrapht.*;
import org.jgrapht.graph.*;

public class GraphParser {
	public static void ParseFileToGraph(SimpleDirectedWeightedGraph <Integer, DefaultWeightedEdge> lGraph){	
		String directory = "/home/zokoo/projects/gis/src/gis/";//bedziesz miała inną ścieżkę
		//String directory = "D://...";
		String fileName = directory + "test.txt"; //plik, zawierający graf do testów
		String line;
		Integer numOfVertex;

		//dodanie wierzchołków do grafu
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
			line = br.readLine(); //przeczytaj pierwsza linie	
			String[] lineParts = line.split(",");
			
			numOfVertex = Integer.parseInt(lineParts[0]);
			
			for (int j=0; j< numOfVertex; j++)
				lGraph.addVertex(j); //dodaj wierzchołki
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//dodanie łuków/krawedzi do grau
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			line = br.readLine(); //omin pierwsza linie
			//System.out.println(line);
			while ((line = br.readLine()) != null) {
				String[] edgeVars = line.split(",");
				
				System.out.println(edgeVars[0] + edgeVars[1] + edgeVars[2]);
				int source = Integer.parseInt(edgeVars[0]);
				int target = Integer.parseInt(edgeVars[1]);
				int weight = Integer.parseInt(edgeVars[2]);
				
				DefaultWeightedEdge edge = lGraph.addEdge(source, target); //źródło,cel
				lGraph.setEdgeWeight(edge, Double.valueOf(weight)); //dodanie wagi do krawedzi
				
				//System.out.println(lGraph.getEdgeWeight(edge));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}		
}
	

