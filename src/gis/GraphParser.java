package gis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.jgrapht.graph.*;

public class GraphParser {
	public static void ParseFileToGraph(SimpleDirectedWeightedGraph <Integer, DefaultWeightedEdge> lGraph){	
<<<<<<< HEAD
		String directory = "test/input/";
		//String directory = "D://...";
		String fileName = directory + "test1.txt"; //plik, zawierajacy graf do testow
=======
		String directory = "src/gis/";
		String fileName = directory + "test.txt"; //plik, zawierajacy graf do testow
>>>>>>> refs/remotes/origin/master
		String line;
		Integer numOfVertex;

		//dodanie wierzcholkow do grafu
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
			line = br.readLine(); //przeczytaj pierwsza linie	
			String[] lineParts = line.split(",");
			
			numOfVertex = Integer.parseInt(lineParts[0]);
			
			for (int j=0; j< numOfVertex; j++)
				lGraph.addVertex(j); //dodaj wierzcholki
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//dodanie lukow/krawedzi do grafu
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			line = br.readLine(); //pomin pierwsza linie
			//System.out.println(line);
			while ((line = br.readLine()) != null) {
				String[] edgeVars = line.split(",");
				
				System.out.println(edgeVars[0] + edgeVars[1] + edgeVars[2]);
				int source = Integer.parseInt(edgeVars[0]);
				int target = Integer.parseInt(edgeVars[1]);
				int weight = Integer.parseInt(edgeVars[2]);
				
				DefaultWeightedEdge edge = lGraph.addEdge(source, target); //zrodlo,cel
				lGraph.setEdgeWeight(edge, Double.valueOf(weight)); //dodanie wagi do krawedzi
				
				//System.out.println(lGraph.getEdgeWeight(edge));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}		
}
	

