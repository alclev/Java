
public class Matrix {

	private int[][] matrix;
	private static int numMatrix = 0;

	public Matrix(int size) {
		matrix = new int[size][size];
		numMatrix++;
		fill();
	}

	public static int getNumMatrix() {
		return numMatrix;
	}

	public void fill() {
		for(int x= 0; x < matrix.length; x++) {
			for(int y=0; y < matrix.length; y++) {
				matrix[x][y]= (int) (10*Math.random());  //I wasn't sure how to make a truly random number without this 
						
			}
		}
	}

	public int[][] display() {
		return matrix;
	}

	public int[][] mult(int scalar) {
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix.length; y++) {
				matrix[x][y] *= scalar;
			}
		}
		return display();
	}

	public int[][] transpose() {
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix.length; y++) { // ...
				matrix[x][y] = matrix[y][x];
			}
		}
		return display();
	}

	public int[][] inverse() {
		if (matrix.length == 2) {
			for (int x = 0; x < matrix.length; x++) {
				for (int y = 0; y < matrix.length; y++) { // ...
					String temp= ""+ (float) (matrix[x][y] * (1/(matrix[1][1]*matrix[0][0]
							-matrix[0][1]*matrix[1][0])));
					temp.substring(indexOf(("."), indexOf((".")+3)));
					matrix[x][y] = Integer.parseInt(temp);
				}
			}
		}
		return display();
	}
}
