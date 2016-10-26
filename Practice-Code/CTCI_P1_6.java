public class CTCI_P1_6 {
	public static void main(String[] args) {
		CTCI_P1_6 I1 = new CTCI_P1_6();
		String s1 = new String("aabbccaadd");
		String s = I1.compress(s1);
		System.out.println(s);
	}
	
	public String compress(String s1) {
		char c1[] = s1.toCharArray();
		StringBuilder s2 = new StringBuilder();
		int charCount = 0;
		for (int i=0; i < c1.length; i++) {
			char c = c1[i];
			if (charCount == 0) {
				charCount++;
			}
			else if (c1[i-1]==c1[i]) {
				charCount++;
			}
			else {
				s2.append(c1[i-1]);
				s2.append(charCount);
				charCount = 1;
			}
		}
		s2.append(c1[c1.length-1]);
		s2.append(charCount);
		String s3 = s2.toString();
		if (s3.length() == s1.length()) return s1;
		else return s3;
	}
}