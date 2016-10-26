public class CTCI_P2_5 {
	public static void main(String[] args) {
		CTCI_LL L1 = new CTCI_LL();
		CTCI_LL L2 = new CTCI_LL();
		CTCI_LL L3 = new CTCI_LL();
		int i = -1; 
		int j = -1;
		int number1 = 0;
		int number2 = 0;
		
		L1.add(6);
		L1.add(1);
		L1.add(7);
		L2.add(2);
		L2.add(9);
		L2.add(5);
		
		for (Node n1 = L1.head; n1!=null;n1 = n1.next){
			i++;
			number1 = number1 + (n1.data)*(int)(Math.pow(10,i));
		}
		System.out.print("L1 : ");
		L1.show_fancy();
		
		for (Node n2 = L2.head; n2!=null;n2 = n2.next){
			j++;
			number2 = number2 + (n2.data)*(int)(Math.pow(10,j));
		}
		System.out.print("L2 : ");
		L2.show_fancy();
		
		
		int number3 = number1 + number2;
		int k = (i>j)? i:j;
		while(k!=-1) {
			int d3 = number3/(int)(Math.pow(10,k));
			number3 = number3%(int)(Math.pow(10,k));
			k--;
			L3.add(d3);
		}
		System.out.print("L3 : ");
		L3.show_fancy();
	}
}