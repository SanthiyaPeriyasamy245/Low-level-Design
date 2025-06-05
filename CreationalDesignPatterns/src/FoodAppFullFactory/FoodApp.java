package FoodAppFullFactory;




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
abstract class Waiter{
	
	public abstract food Make_food();
	
}
class PizzFactory extends Waiter{

	@Override
	public Pizza Make_food() {
		return new Pizza();
		
	}
	
}
class BurgarFactory extends Waiter{

	@Override
	public Burgar Make_food() {
		return new Burgar();
		
	}
	
}
class PastaFactory extends Waiter{

	@Override
	public Pasta Make_food() {
		return new Pasta();
		
	}
	
}

public class FoodApp {
	
	public static void main(String[]args)
	{
		
	
		Waiter waiter=new PastaFactory();
		food Food=waiter.Make_food();
		System.out.print("food-Ready !");
		Food.get_food();
		
	}
	// here object creation handled by factory class..
	

}



