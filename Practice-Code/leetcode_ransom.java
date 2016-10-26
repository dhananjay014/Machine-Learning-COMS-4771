import java.util.ArrayList;
import java.util.*;

public class leetcode_ransom {
	public static void main(String[] args) {
		System.out.println("Start of program");
		String s1 = new String ("anagram");
		String s2 = new String ("nagaram");
		leetcode_ransom I1 = new leetcode_ransom();
		boolean b1 = I1.isAnagram(s1,s2);
		System.out.println(b1);
	}
	
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) return false;
        ArrayList<Character> arr1 = new ArrayList<Character>();
        ArrayList<Character> arr2 = new ArrayList<Character>();
        // adding s into arr1
        for (int i = 0; i < s.length();i++) {
            arr1.add(s.charAt(i));
        }
        // adding t into arr2
        for (int i = 0; i < t.length();i++) {
            arr2.add(t.charAt(i));
        }
        
        for (char c : arr1) {
            Character ch = new Character(c);
            if (arr2.contains(ch)) {
                arr2.remove(ch);
            }
        }
        return arr2.isEmpty();
    }
}