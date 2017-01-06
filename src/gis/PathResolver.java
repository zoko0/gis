package gis;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

public class PathResolver {

	public static int[] FindMinWidthPath(SimpleDirectedWeightedGraph<Integer, DefaultWeightedEdge> graph, int source,
			int dest) {

		int graphSize = graph.vertexSet().size();
		int[] width = new int[graphSize]; // shortest known distance from source
		int[] prev = new int[graphSize]; // prev node in path
		boolean[] visited = new boolean[graphSize]; // all false initially

		for (int i = 0; i < graphSize; i++) {
			width[i] = Integer.MIN_VALUE;
		}

		Comparator<Vertex> comparator = new MinWidthVertexComparator();
		PriorityQueue<Vertex> q = new PriorityQueue<Vertex>(graphSize, comparator);

		q.add(new Vertex(source, width[source]));

		while (!q.isEmpty()) {
			
			Vertex next = q.poll();
			visited[next.getIndex()] = true;

			if (next.getIndex() == dest)
				break;

			List<DefaultWeightedEdge> neighbours = new LinkedList<DefaultWeightedEdge>();
			graph.outgoingEdgesOf(next.getIndex()).forEach(e -> neighbours.add(e));

			for (DefaultWeightedEdge edge : neighbours) {

				int t = graph.getEdgeTarget(edge);

				if (!visited[t]) {
					int d = Math.min(width[t], Math.min(width[next.getIndex()], (int) graph.getEdgeWeight(edge)));

					if (width[t] > d) {
						width[t] = d;
						prev[t] = next.getIndex();
						q.add(new Vertex(t, width[t]));
					}
				}
			}
		}

		return prev;
	}

	public static int[] FindMaxWidthPath(SimpleDirectedWeightedGraph<Integer, DefaultWeightedEdge> graph, int source, int dest) {

		int graphSize = graph.vertexSet().size();
		int[] width = new int[graphSize]; // shortest known distance from source
		int[] prev = new int[graphSize]; // prev node in path
		boolean[] visited = new boolean[graphSize]; // all false initially

		for (int i = 0; i < graphSize; i++) {
			width[i] = Integer.MIN_VALUE;
		}

		Comparator<Vertex> comparator = new MaxWidthVertexComparator();
		PriorityQueue<Vertex> q = new PriorityQueue<Vertex>(graphSize, comparator);

		q.add(new Vertex(source, width[source]));

		while (!q.isEmpty()) {
			
			Vertex next = q.poll();
			visited[next.getIndex()] = true;

			if (next.getIndex() == dest)
				break;

			List<DefaultWeightedEdge> neighbours = new LinkedList<DefaultWeightedEdge>();
			graph.outgoingEdgesOf(next.getIndex()).forEach(e -> neighbours.add(e));

			for (DefaultWeightedEdge edge : neighbours) {

				int t = graph.getEdgeTarget(edge);

				if (!visited[t]) {
					int d = Math.max(width[t], Math.max(width[next.getIndex()], (int) graph.getEdgeWeight(edge)));

					if (width[t] > d) {
						width[t] = d;
						prev[t] = next.getIndex();
						q.add(new Vertex(t, width[t]));
					}
				}
			}
		}

		return prev;
	}


}
