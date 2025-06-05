package FoodAppWithFactory;



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
class Waiter{
	
	public void Make_food(String food)
	{
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
	}
}
public class FoodApp {
	
	public static void main(String[]args)
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the food you want");
		String food=scanner.next();
		Waiter waiter=new Waiter();
		waiter.Make_food(food);
		scanner.close();
		
	}
	// still it voilates the open close principle.
	

}


