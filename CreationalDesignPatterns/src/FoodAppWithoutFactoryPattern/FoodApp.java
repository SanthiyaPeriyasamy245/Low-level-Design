package FoodAppWithoutFactoryPattern;

import java.util.Scanner;

interface food{
	void get_food();
}
class Pizza implements food{

	@Override
	public void get_food() {
		
		System.out.println("Pizza ready");
	}
	
}

class Burgar implements food{

	@Override
	public void get_food() {
		
		System.out.println("burgar ready");
	}
	
	
}
class Pasta implements food{

	@Override
	public void get_food() {
		System.out.println("Pasta ready");
		
	}
	
}
public class FoodApp {
	
	public static void main(String[]args)
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the food you want");
		String food=scanner.next();
		if(food.equals("pizza"))
		{
			Pizza pizza=new Pizza();
			pizza.get_food();
		}
		else if(food.equals("burgar"))
		{
			Burgar burgar=new Burgar();
			burgar.get_food();
		}
		else {
			Pasta pasta=new Pasta();
			pasta.get_food();
		}
		scanner.close();
		// in this code object creation is handled by client side
		// it's tidely coupled.
	}
	

}
