public class ShellSort {
    
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while(h < N/3) h = 3*h+1;
        
        while (h>=1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j],a[j-h]); j-=h) {
                    exch(a,j,j-h);
                }
            }
            h = h/3;
        }
    }
    
    private static boolean less (Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    
    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    public static void main (String[] args){
        int N = Integer.parseInt(args[0]);
        Date [] arr = new Date [N];
        for (int k = 0;k < N; k++) {
            int y = 1000 +(int) ((StdRandom.uniform()*10000)%1000);
            int m = 1 + (int) ((StdRandom.uniform()*100)%12);
            int d = 1 + (int) ((StdRandom.uniform()*100)%30);
            arr[k] = new Date (m,d,y);
        }
        sort(arr);
        for (int l = 0; l < N; l++) {
            StdOut.println(arr[l].day+"-"+arr[l].month+"-"+arr[l].year);
        }
    }
}