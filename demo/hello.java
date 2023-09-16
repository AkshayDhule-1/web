package demo;

public class hello extends Animal {
	
	public void bark() {
		System.out.println("Dog is barking.");
	}
	
	public static void main(String args[]) {
		System.out.println("This is inside hello world.");
		
		hello dog = new hello();
		dog.walk();
		dog.bark();
	}
}



