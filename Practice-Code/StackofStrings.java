public class StackofStrings {
    private Node first = null;
    
    private class Node {
        String item;
        Node next;
    }
    
    public Boolean isEmpty() {
        return first == null;
    }
    
    public void push(String S) {
        Node temp = new Node();
        temp.item = S;
        Node oldfirst = first;
        first = temp;
        first.next = oldfirst;
    }
    
    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }
    
    public static void main(String[] args) {
        //StackofStrings s1 = new StackofStrings();
        //StackofStrings s1;                    //s1 is not initialized without new
        //s1 = new StackofStrings();            //no symbol, Java doesn't know what symbol what datatype it is
        System.out.println(s1.isEmpty());
        s1.push("Hello");
        s1.push("How are you?");
        System.out.println(s1.isEmpty());
        String str;
        str = s1.pop();
        System.out.println(str);
        str = s1.pop();
        System.out.println(str);
        System.out.println(s1.isEmpty());
    }
}