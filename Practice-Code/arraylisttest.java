import java.util.ArrayList;

public class arraylisttest {
	ArrayList<String> merge (String[] words, String[] more) {
		ArrayList<String> sentence  = new ArrayList<String>();
		for (String w : words) sentence.add(w);
		for (String w : more)  sentence.add(w);
		return sentence;		
	}
	
	public static void main(String[] args) {
		System.out.println("Program starts");
		arraylisttest alt1 = new arraylisttest();
		//String words = new String("Hey, My name is DJ");
		String[] String1 = new String[3];
		String1[0] = "Hey";
		String1[1] = "How";
		String1[2] = "are";
		
		String[] String2 = new String[3];
		String2[0] = "I";
		String2[1] = "am";
		String2[2] = "fine";
		//String more = new String("I study in Columbia University");
		ArrayList<String> A1 = alt1.merge(String1,String2);
		System.out.println("String is ");
		for (String w : A1) {
			System.out.println(w);			
		}
		System.out.println("The program is over");
		
	}
}