import java.util.Arrays;

public class CTCI_P1_2 {
	public static void main(String[] args) {
		System.out.println("The program starts");
		
		String s1 = new String("Heyhowaheyou");
		String s2 = new String("Heyhowareyou");
		
		if (s1.length() != s2.length()) {
			System.out.println("They are not permutations of each other");
			System.out.println("The program ends");
			return;
		}
		
		char[] char1 = s1.toCharArray();
		char[] char2 = s2.toCharArray();
		Arrays.sort(char1);
		Arrays.sort(char2);
		s1 = new String(char1);
		s2 = new String(char2);
		System.out.println(s1);
		System.out.println(s2);
		
		if (s1.compareTo(s2) == 0) {
			System.out.println("The strings are permutations of each other");
		} else {
			System.out.println("The strings are not permutations of each other");
		}
		
		
		
//		Solution 2
//		int length1 = s1.length();
//		int length2 = s2.length();
//		
//		if (length1 != length2) {
//			System.out.println("They are not permutations of each other");
//			System.out.println("The program ends");
//			return;
//		}
//		
//		int[] character_counts = new int[128];
//		for (int i=0; i < s1.length(); i++) {
//			int x = s1.charAt(i);
//			character_counts[x]++;
//		}
//		
//		for (int j = 0; j < s2.length(); j++) {
//			int y = s2.charAt(j);
//			if (character_counts[y] > 0) {
//				character_counts[y]--;
//			}
//		}
//
//		int sum = 0;
//		for (int k = 0; k < 128; k++) {
//			sum = sum+character_counts[k];
//		}
//		
//		if (sum == 0) {
//			System.out.println("They indeed are permutations of each other");
//		} else {
//			System.out.println("They are not permutations of each other");
//		}
//		System.out.println("The program ends");
	}
}