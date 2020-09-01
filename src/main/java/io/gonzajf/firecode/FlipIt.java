package io.gonzajf.firecode;

public class FlipIt {

	/**
	 *  You are given an m x n 2D image matrix where each integer represents a pixel. 
	 *  Flip it in-place along its vertical axis.
	 */
	public static void flipItVerticalAxis(int[][] matrix) {
	    
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length/2; j++) {
				int temp = matrix[i][j]; 
				matrix[i][j] = matrix[i][matrix[j].length-1-j];
				matrix[i][matrix[j].length-1-j] = temp;
			}
		}
	}
	
	/**
	 * You are given an m x n 2D image matrix where each integer represents a pixel. 
	 * Flip it in-place along its horizontal axis.
	 */
	public static void flipHorizontalAxis(int[][] matrix) {
		for (int i = 0; i < matrix.length/2; i++) {
			for (int j = 0; j < matrix.length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix[j].length-1-j];
				matrix[i][matrix[j].length-1-j] = temp;
			}
		}
		System.out.println(matrix);
	}
	
	public static void main(String[] args) {
		int[][] arr = {{1,1}, {0,0}};
		flipHorizontalAxis(arr);
	}
}
