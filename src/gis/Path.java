package gis;

import java.util.LinkedList;
import java.util.List;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

public class Path {

	private List<Integer> mPath;
	private int mMinWidth;
	private int mMaxWidth;

	public Path(SimpleDirectedWeightedGraph<Integer, DefaultWeightedEdge> graph, int[] prev, int source, int dest) {

		int node = dest;
		mMinWidth = Integer.MAX_VALUE;
		mMaxWidth = Integer.MIN_VALUE;
		mPath = new LinkedList<Integer>();

		while (prev.length > node && node >= 0 && prev[node] >= 0 && node != source) {

			DefaultWeightedEdge edge = graph.getEdge(prev[node], node);
			int weight = (int) graph.getEdgeWeight(edge);
			if (weight < mMinWidth)
				mMinWidth = weight;
			if (weight > mMaxWidth)
				mMaxWidth = weight;

			mPath.add(0, node);
			node = prev[node];
		}

		mPath.add(0, source);

		if (node < 0 || (prev[node] < 0 && node != source) || source == dest)
			mPath.clear();

	}

	public int getMinWidth() {
		return mMinWidth;
	}

	public int getMaxWidth() {
		return mMaxWidth;
	}

	public String toString() {
		if (mPath.size() == 0)
			return "Path doesn't exist";

		StringBuilder sb = new StringBuilder();
		for (Integer node : mPath)
			sb.append(node + ",");

		sb.append(" min: " + mMinWidth);
		sb.append(" max: " + mMaxWidth);

		return sb.toString();

	}
}
