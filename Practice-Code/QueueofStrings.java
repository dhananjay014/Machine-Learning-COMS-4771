public class QueueofStrings {
    private Node first = null;
    
    private class Node {
        String item;
        Node next;
    }
    
    public Boolean isEmpty(){
        return first == null;
    }
    
    public void push (String item) {
        Node temp = new Node();
        temp.next = null;
        temp.item = item;
        Node iter, prev;
        if (first == null) { first = temp;}
        else {
            iter = first;
            while (iter.next != null) {
                //prev = iter;
                iter = iter.next;
            }
            iter.next = temp;
            //prev = temp;
        }
    }
    
    public String pop() {
        String s = first.item;
        //System.out.println("pop start");
        //System.out.println(first.item);
        //System.out.println("pop finish");
        first = first.next;
        return s;
    }
    
    public static void main(String[] args){
        QueueofStrings s = new QueueofStrings();
        System.out.println(s.isEmpty());
        s.push("Hello");
        System.out.println(s.isEmpty());
        s.push("How're you?");
        String str;
        str = s.pop();
        System.out.println(str);
        str = s.pop();
        System.out.println(str);
    }
}