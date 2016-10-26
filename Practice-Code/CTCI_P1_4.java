public class CTCI_P1_4 {
	boolean checkpermpalin(String s) {
		int length = s.length();
		char[] chars = s.toCharArray();
		int[] charcounts = new int[128];
		for (char c : chars) {
			charcounts[c]++;
		}
		
		boolean one_occurred = false;
		
		for (int i = 0; i < 128; i++) {
			if (charcounts[i]%2 == 0) {
				continue;
			} else if (one_occurred == false) {
				one_occurred = true;
			} else {
				return false;
			}
		}
		return true;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("Start of program");
		String s1 = new String("yayajk");
		String s2 = new String("bbb");
		CTCI_P1_4 p1 = new CTCI_P1_4();
		boolean b1 = p1.checkpermpalin(s2);
		System.out.println(b1);
		System.out.println("End of program");
	}
}