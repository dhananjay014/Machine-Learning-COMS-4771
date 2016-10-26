public class CTCI_P1_1 {
	public static void main(String[] args) {
		String s1 = new String("Heyhowru?");
		//System.out.println(s1.charAt(0));
		
		boolean[] barray = new boolean[128];
		for (int i = 0; i < s1.length(); i++) {
			int x = (int) (s1.charAt(i));
			if (barray[x] == false) {
				barray[x] = true;
			}
			else {
				System.out.println("The string is not unique");
				return;
			}
		}
		
		System.out.println("The string is actaully unique");
		
		//for (int i = 0; i < s1.length(); i++) {
		//	for (int j = i+1; j < s1.length(); j++) {
		//		if(s1.charAt(i) == s1.charAt(j)) {
		//			System.out.println("Found that the string is not unique");
		//			return;
		//		}
		//	}
		//}
		//System.out.println("The string is actually unique. Strange!");
	}
}