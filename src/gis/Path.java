package gis;

import java.util.LinkedList;
import java.util.List;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

public class Path {

	private List<Integer> mPath;
	private int mWidth;

	public Path(SimpleDirectedWeightedGraph<Integer, DefaultWeightedEdge> graph, int[] prev, int source, int dest, boolean isMax) {

		int node = dest;
		if(isMax)
			mWidth = Integer.MIN_VALUE;
		else
			mWidth = Integer.MAX_VALUE;
		
		mPath = new LinkedList<Integer>();

		while (prev.length > node && node >= 0 && prev[node] >= 0 && node != source) {

			DefaultWeightedEdge edge = graph.getEdge(prev[node], node);
			int weight = (int) graph.getEdgeWeight(edge);
			
			if (!isMax && weight < mWidth)
				mWidth = weight;
			else if (isMax && weight > mWidth)
				mWidth = weight;

			mPath.add(0, node);
			node = prev[node];
		}

		mPath.add(0, source);

		if (node < 0 || (prev[node] < 0 && node != source) || source == dest)
			mPath.clear();

	}

	public int getWidth() {
		return mWidth;
	}

	public String toString() {
		if (mPath.size() == 0)
			return "Path doesn't exist";

		StringBuilder sb = new StringBuilder();
		for (Integer node : mPath)
			sb.append(node + ",");

		sb.append(" value: " + mWidth);

		return sb.toString();

	}
}
