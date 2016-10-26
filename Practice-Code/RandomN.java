public class RandomN {
    public static void main(String[] args) {
        double [] a = new double[10];
        for (int i = 0; i < 10; i++) {
            a[i] = StdRandom.uniform();
            StdOut.println(a[i]);
        }
    }
}