public class ArrayPrint {
	public static void main (String[] args) {
		int [] a = new int [10];
		for (int i = 0; i < 10; i++) {
			a[i] = i;
		}
		for (int j = 0; j < 10; j++) {
			System.out.println(a[j]);
		}
	}
}