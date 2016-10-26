public class CTCI_P1_5 {
	public static void main(String[] args) {
		//String s1 = new String("heyya");
		System.out.println("Start of program");
		String s1 = new String("pale");
		String s2 = new String("pasle");
		CTCI_P1_5 I1 = new CTCI_P1_5();
		boolean result1  = I1.oneEditInsert(s1,s2);
		boolean result2 = I1.OneEditChecker(s1,s2);
		if (result1 == result2) System.out.println("Verified");
		else 					System.out.println("Not verified");
	//	System.out.println(result);
	}
	
	public boolean OneEditChecker(String s1, String s2){
		int [] charcounts = new int[26];
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		for (int i = 0; i < c1.length;i++) {
			int x = charconvert(c1[i]);
			charcounts[x]++;
		}	
		
		for (int i=0; i < c2.length;i++) {
			int x = charconvert(c2[i]);
			if (charcounts[x] > 0) {
				charcounts[x]--;
			} else {
				charcounts[x]++;
			}
		}
		
		int sum = 0;
		for (int i = 0; i < 26; i++) {
			//System.out.println(charcounts[i]);
			if (charcounts[i] > 0) {
				sum++;
			}
		}
		if (sum<=2) return true;
		else return false;
	}
	
	public int charconvert(char c){
		char c1 = 'a';
		return (int) (c-c1);
	}
	
	boolean oneEditInsert(String first, String second) {
		if (Math.abs(first.length() - second.length()) > 1) {
			return false;
		}
	
		String s1 = first.length() < second.length()? first:second;
		String s2 = first.length() < second.length()? second:first;
		
		//s1 is the shorter string related to index 1
		//s2 is the longer string related to index 2
		
		int index1 = 0;
		int index2 = 0;
		
		boolean foundDifference = false;
		while (index2 < s2.length() && index1 < s1.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				if (foundDifference) return false;
				foundDifference  = true;
				
				if (s1.length() == s2.length()) {
					index1++;
				}
			} else {
				index1++;
			}
			index2++;
		}
		return true;
	}
}