public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        int N = Integer.parseInt(args[0]);
        //find largest power
        int largest_power = findlargestpower(N);
        System.out.println(largest_power);
        double binary = findbinary(N,largest_power);
        System.out.println(binary);
     }
     
     public static int findlargestpower(int N){
         int quot=1;
         int i=-1;
         while (quot>=1)
         {
            i++;
            quot = (int) (N/(Math.pow(2,i)));
         }
         i--;
         return i;
     }
     
     public static double findbinary(int N, int largest_power) {
         int n = N;
         double binary = 0.0;
         int i = largest_power;
         while (n>0)
         {
             if ((int)(n/Math.pow(2,i)) == 1)
             {
                 binary+= (double)(Math.pow(10,i));
             }
             n = (int)(n % Math.pow(2,i));
             i--;
         }
         return binary;
     }
}
