public class KnuthShuffling {
    public static void shuffle(Object[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = StdRandom.uniform(i+1);
            exch(a,i,r);
        }
    }
    
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            //a[i] = (Integer) (StdRandom.uniform(n+1));
            a[i] = i;
            System.out.println(a[i]);
        }
        shuffle(a);
        System.out.println("Shuffled array is");
        for (int j = 0; j < n; j++) {
            System.out.println(a[j]);
        }
    }
}