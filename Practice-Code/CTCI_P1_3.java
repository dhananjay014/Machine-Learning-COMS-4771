public class CTCI_P1_3 {
	
	void convert20(char[] chars, int length) {
		int space_count = 0;
		for (int i = 0; i < length; i++) {
			if (chars[i] == ' ') {
				space_count++;
			}
		}
		
		int bigger_length = length + space_count*2;
		System.out.println(bigger_length);
		chars[bigger_length] = '\0';
		for (int i = length-1; i >= 0; i--) {
			if (chars[i] == ' ') {
				chars[bigger_length-1] = '0';
				chars[bigger_length-2] = '2';
				chars[bigger_length-3] = '%';
				bigger_length = bigger_length-3;
			} else {
				chars[bigger_length-1] = chars[i];
				bigger_length = bigger_length-1;
			}
		}
		System.out.println("Hey the new string is ");
		
		for (int i = 0; i < length + space_count*2; i++) {
			System.out.print(chars[i]);
		}
	}
	
	
	public static void main(String[] args) {
		String s1 = new String("yo");
		char[] chars = "Mr John Smith     ".toCharArray();
		CTCI_P1_3 instance1 = new CTCI_P1_3();
		instance1.convert20(chars,13);
	}
}