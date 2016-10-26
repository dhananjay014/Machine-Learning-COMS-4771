public class Dog extends Animal implements Pets{
	int bark_ability;
	String tag_name;
	
	public void display() {
		System.out.println("Message from Dog class");
	}
	
	public Animal assign(Animal a) {
		return a;
	}
	
	public void put() {
		Dog d1 = new Dog();
		Animal d2 = assign(d1);
		Animal A1 = new Dog();
		A1.display();
		
	}
	
	public static void main(String[] args) {
		Dog d1 = new Dog();
		d1.display();
		
		Animal a1 = new Dog();
		a1.display();
		
		Animal a2 = new Animal();
		a2.display();
	}
}