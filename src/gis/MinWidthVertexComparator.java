package gis;

import java.util.Comparator;

// comparator used with min priority queue
public class MinWidthVertexComparator implements Comparator<Vertex> {

	@Override
	public int compare(Vertex v1, Vertex v2) {
		
		if (v1.getWidth() < v2.getWidth()) {
			return -1;
		}
		if (v1.getWidth() > v2.getWidth()) {
			return 1;
		}
		return 0;
	}

}
