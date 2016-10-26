import java.util.ArrayList;

public class CTCI_P1_8 {
//	public static void main(String[] args) {
//		System.out.println("yay");
//		ArrayList<point> pointarr = new ArrayList<point>();
//		int count = 0;
//		int[][] matrix = new int [4][6];
//		CTCI_P1_8 I1 = new CTCI_P1_8();
//		int length1 = matrix.length;
//		int length2 = matrix[0].length;
//		for (int i = 0; i < length1; i++) {
//			for (int j = 0; j < length2; j++) {
//				matrix[i][j] = count++;
//			}
//		}
//		
//		matrix[0][2] = 0;
//		matrix[2][4] = 0;
//		matrix[3][1] = 0;
//		matrix[0][4] = 0;
//	//	matrix[3][3] = 0;
//	//	matrix[3][5] = 0;
//		
//		
//		System.out.println("");
//		System.out.println("Here is the real matrix");
//		I1.displaymatrix(matrix,length1,length2);
//		
//		int sum = 0;
//		for (int i=0;i<length1;i++) {
//			for (int j = 0; j < length2; j++) {
//				sum = sum+matrix[i][j];
//			}
//		}
//		
//		for (int i=0;i<length1;i++) {
//			for (int j = 0; j < length2; j++) {
//				if (matrix[i][j] == 0) matrix[i][j] = sum;
//			}
//		}
//		System.out.println("");
//		System.out.println("Here is sum converted matrix");
//		I1.displaymatrix(matrix,length1,length2);
//		
//		for (int i=0;i<length1;i++) {
//			for (int j = 0; j < length2; j++) {
//				if (matrix[i][j] == sum) {
//					for (int k = 0; k < length1; k++) {
//						if (matrix[k][j]!=sum) matrix[k][j] = 0;
//					}
//					for (int k = 0; k < length2; k++) {
//						if (matrix[i][k]!=sum) matrix[i][k] = 0;
//					}
//					matrix[i][j] = 0;
//				}
//			}
//		}
//		
//		System.out.println("");
//		System.out.println("Here is the final matrix");
//		I1.displaymatrix(matrix,length1,length2);
//		
//		
////		for (int i = 0; i < length1; i++) {
////			for (int j = 0; j < length2; j++) {
////				if (matrix[i][j] == 0) {
////					pointarr.add(new point(i,j));
////				}
////			}
////		}
////		
////		for (point p1 : pointarr) {
////			int row = p1.x;
////			int column = p1.y;
////			// DOING FOR ALL COLUMNS
////			for (int i = 0; i < length2; i++) {
////				matrix[row][i] = 0;
////			}
////			// DOING FOR ALL ROWS
////			for (int i = 0; i < length1; i++) {
////				matrix[i][column] = 0;
////			}
////		}
//	
////		System.out.println("Here is the converted matrix");
////		I1.displaymatrix(matrix,length1,length2);
//	}

	public static void main(String[] args) {
		System.out.println("yay");
		int[][] matrix = new int [4][6];
		CTCI_P1_8 I1 = new CTCI_P1_8();
		int length1 = matrix.length;
		int length2 = matrix[0].length;
		boolean[] rows = new boolean[length1];
		boolean[] columns = new boolean[length2];
		int count = 0;
		for (int i = 0; i < length1; i++) {
			for (int j = 0; j < length2; j++) {
				matrix[i][j] = count++;
			}
		}
		
		matrix[0][2] = 0;
		matrix[2][4] = 0;
		matrix[3][1] = 0;
		matrix[0][4] = 0;
	//	matrix[3][3] = 0;
	//	matrix[3][5] = 0;
		
		for(int i = 0 ; i < length1; i++) {
			for (int j = 0; j < length2; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = true;
					columns[j] = true;
				}
			}
		}
		
		for (int i =0; i < length1; i++) {
			if (rows[i] == true) 
				I1.setrow0(matrix,length2,i);
		}
		
		for (int i = 0; i < length2;i++) {
			if (columns[i] == true)
				I1.setcolumn0(matrix,length1,i);
		}
		
		I1.displaymatrix(matrix,length1,length2);
	}
	
	public void setrow0(int[][] matrix,int length2,int row) {
		for(int i = 0; i < length2;i++) {
			matrix[row][i] = 0;
		}
	}
	
	public void setcolumn0(int[][] matrix,int length1,int column) {
		for(int i = 0; i < length1;i++) {
			matrix[i][column] = 0;
		}
	}
	
	public void displaymatrix(int[][] matrix1,int l1,int l2) {
		for (int i=0;i<l1; i++) {
			for (int j = 0; j < l2; j++) {
				System.out.print(matrix1[i][j] + "\t");
			}
			System.out.println(" ");
		}
	}
	
	public static class point {
		public int x;
		public int y;
		
		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}