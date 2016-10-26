public class Date implements Comparable<Date> {
        public final int month, day, year;
        
        public Date (int m, int d, int y) {
            month = m;
            day = d;
            year = y;
        }
        
        public int compareTo(Date that) {
            if (this.year  < that.year)  return -1;
            if (this.year  > that.year)  return 1;
            if (this.month < that.month) return -1;
            if (this.month > that.month) return 1;
            if (this.day   < that.day)   return -1;
            if (this.day   > that.day)   return 1;
            return 0;
        }
        
        public boolean less(Comparable a, Comparable b) {
        	return a.compareTo(b) < 0;
        }
        
        //public void exch (Comparable a, Comparable b) {
        //	Comparable swap  = a;
        //	a = b;
        //	b = swap;
        //}
        
        //public void exch (Comparable[] a, int i, int j) {
        //	Comparable swap = a[i];
        //	a[i] = a[j];
        //	a[j] = swap;
        //} 
    }