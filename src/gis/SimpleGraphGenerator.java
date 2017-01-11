package gis;

import org.jgrapht.graph.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SimpleGraphGenerator {
	public static void doGenerate(SimpleDirectedWeightedGraph
				      <Integer, DefaultWeightedEdge> lGraph, int verCount, double probEdge){	
		Random random = new Random();
		int randomWeight;
		int minWeight = 0;
		int maxWeight = 10;
		
		//dodaj wierzcholki
		for (int i = 0; i < verCount; i++) {
			lGraph.addVertex(i); //dodaj wierzcholki
		}    			
		
		//dodaj krawedzie
		for (int i = 0; i < verCount; i++) {
		    for (int j = i + 1; j < verCount; j++) {

				randomWeight = ThreadLocalRandom.current().nextInt(minWeight, maxWeight + 1);
				//System.out.println(randomWeight);
	
				double randomProb = random.nextDouble();
				if (randomProb <= probEdge) {
					DefaultWeightedEdge edge = lGraph.addEdge(i, j); //zrodlo,cel
						lGraph.setEdgeWeight(edge, Double.valueOf(randomWeight)); //dodanie wagi do krawedzi
				}
		    }
		}
	}
} //end of class

