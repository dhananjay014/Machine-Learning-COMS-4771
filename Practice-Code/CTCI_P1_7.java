public class CTCI_P1_7 {
	public static void main(String[] args) {
		int[][] matrix = new int[4][4];
		int count = 1;
		for(int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				matrix[i][j] = count++;
			}
		}

		CTCI_P1_7 I1 = new CTCI_P1_7();
		boolean b1 = I1.rotate(matrix);
		
//		int [][]matrix1 = new int[4][3];
//		System.out.println("here is the matrix");
//		System.out.println(matrix1.length);
//		
//		CTCI_P1_7 I1 = new CTCI_P1_7();
//		int [][] rmatrix;
//		rmatrix = I1.rotatematrix(matrix,4);
//		
//		System.out.println("Here is normal matrix");
//		for(int i = 0; i < 4; i++) {
//			for (int j = 0; j < 4; j++) {
//				System.out.print(matrix[i][j] + "\t");
//			}
//			System.out.println(" ");
//		}
//		
//		System.out.println("Here is rotated matrix");
//		for(int i = 0; i < 4; i++) {
//			for (int j = 0; j < 4; j++) {
//				System.out.print(rmatrix[i][j] + "\t");
//			}
//			System.out.println(" ");
//		}
	}
	
	public int[][] rotatematrix(int[][] matrix, int N) {
		int[][] rmatrix = new int[N][N];
		for (int i = 0; i < N; i++){
			for (int j = 0; j < N; j++) {
				rmatrix[j][N-i-1] = matrix[i][j];
			}
		}
		return rmatrix;
	}
	
	boolean rotate(int[][] matrix) {
		if (matrix.length == 0 || matrix.length!=matrix[0].length) return false;
		int n = matrix.length;
		for (int layer = 0; layer < n/2; layer++) {
			int first = layer;
			int last = n-1-layer;
			for (int i = first; i < last; i++) {
				int offset = i-first;
				
				int top = matrix[first][i];
				matrix[first][i] = matrix[last-offset][first];
				matrix[last-offset][first] = matrix[last][last-offset];
				matrix[last][last-offset] = matrix[i][last];
				matrix[i][last] = top;
			}
		}
		return true;
	}
}