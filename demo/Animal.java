package demo;

public class Animal {
	int eyes = 2;
	int legs = 4;
	
	Animal(){
		System.out.println("Default Constructor.");
	}
	
	Animal(int eyes, int legs){
		this.eyes = eyes;
		this.legs = legs;
	}
	
	public void walk() {
		System.out.println("Animal can walk");
	}
}
