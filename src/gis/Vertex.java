package gis;

public class Vertex {

	private int mIndex;
	private int mWidth;

	public Vertex(int index, int width){
		mIndex = index;
		mWidth = width;
	}
	
	public int getWidth() {
		return mWidth;
	}

	public void setWidth(int width) {
		mWidth = width;
	}

	public int getIndex() {
		return mIndex;
	}

	public void setIndex(int index) {
		mIndex = index;
	}
}
