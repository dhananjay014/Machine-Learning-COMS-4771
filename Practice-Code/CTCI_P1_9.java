public class CTCI_P1_9 {
	public static void main(String[] args) {
		System.out.println("start of program");
		String s1 = new String("waterbottle");
		String s2 = new String("erbottlewat");
		//s2 = s2+s2;
//		if(s2.contains(s1)) {
//			System.out.println("ho gya");
//			return;
//		}
//		//System.out.println(s2);
		CTCI_P1_9 I1 = new CTCI_P1_9();
		boolean b1 = I1.checkrotation(s1,s2);
		System.out.println(b1);
	}
	
	public boolean checkrotation(String s1, String s2) {
		
		if (s1.length() != s2.length()) {return false;}
		String s3 = s2+s2;
		System.out.println(s3);
		if (isSubString(s3,s1)) {
			return true;
		}
		return false;
	}
	
	public boolean isSubString(String s2,String s1) {
		if (s2.contains(s1)) return true;
		else return false;
	}
}