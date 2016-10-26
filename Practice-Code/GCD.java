public class GCD {
    public static void main ( String[] args) {
        int N1 = Integer.parseInt(args[0]);
        int N2 = Integer.parseInt(args[1]);
        int GCD = findGCD(N1,N2);
        System.out.println(GCD);
        
    }
    
    public static int findGCD(int N1, int N2) {
        int big,small;
        if (N1 > N2)
        {
            big = N1;
            small = N2;
        }
        else 
        {
            big = N2;
            small  = N1;
        }
        if ((big%small) == 0)
        { 
            return small;
        }
        else
        {
            int rem = big % small;
            return findGCD(rem, small);
        }
    }
}