public class BST_outdated <Key extends Comparable<Key>, Value> {
    private Node root;

// NODE CLASS    
    private class Node {
        private Key key;
        private Value val;
        private Node left,right;
        
        public Node (Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }
    
//PUTTING INTO BST    
    public void put (Key key, Value val) {
        root = put (root,key,val);
    }
    
    private Node put (Node x, Key key, Value val) {
        if (x==null)        return new Node (key,val);
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = put (x.right,key,val);
        }
        else if (cmp < 0) {
            x.left = put (x.left,key,val);
        }
        else    x.val = val;
        return x;
    }

//FINDING MAXIMUM    
    public Key max() {
        Node temp = root;
        //Key key = new Key();
        //Value val;
        while (temp.right!=null) {
            temp = temp.right;
            //key = temp.key;
            //val = temp.val;
        }
        return temp.key;
    }

//FINDING MINIMUM    
    public Key min() {
        Node temp = root;
        //Key key = new Key();
        //Value val;
        while (temp.left!=null) {
            temp = temp.left;
            //key = temp.key;
            //val = temp.val;
        }
        return temp.key;
    }

// GETTING A KEY    
    public Value get (Key key) {
        Node temp = root;
        //if (temp == null) {System.out.prinln("The tree is empty") return null;}
        while (temp != null) {
            int cmp = key.compareTo(temp.key);
            if      (cmp > 0) temp = temp.left;
            else if (cmp < 0) temp = temp.right;
            else              return temp.val;
        }
        return null;
    }

//DELETING A KEY    
    public void delete (Key key) {
        Node temp = root;
        while (temp != null) {
            int cmp = key.compareTo(temp.key);
            if      (cmp > 0)    temp = temp.right;
            else if (cmp < 0)    temp = temp.left;
            else                 {System.out.println("The key we delete is " + temp.key + " the value is " + temp.val); temp = null; }
        }
    }
    
    public Key floor   (Key key) {return null;}
    public Key ceiling (Key key) {return null;}
    
    public Iterable<Key> iterator () {return null;}
    
    public static void main (String[] args)
    {
        BST_outdated<Integer,String> BST1 = new BST_outdated<Integer,String>();
        BST1.put(10,"John Lennon");
        BST1.put(20,"Michael Jackson");
        BST1.put(30,"Jimi Hendrix");
        BST1.put(40,"Joe Satriani");
        System.out.println("The value at 10 is " + BST1.get(10));
        System.out.println("The max is "+ BST1.max());
        System.out.println("The min is "+ BST1.min());
        System.out.println("We now delete 30");
        BST1.delete(30);
    }
}