package practice;

class TV{
	private int size;
	public TV(int size) {
		size = 10;
	}
}

class ColorTV extends TV {
	private int colors;
	public ColorTV(int colors, int size) {
		super(size);
		this.colors = colors;
	}

}

public class Example04 {
	public static void main(String[] args) {
		
	}
}
