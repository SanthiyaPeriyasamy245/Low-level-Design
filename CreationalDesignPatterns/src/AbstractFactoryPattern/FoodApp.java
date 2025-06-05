package AbstractFactoryPattern;



interface food{
	abstract void prepare();
	
}
class pizza implements food{

	@Override
	public void prepare() {
		
		System.out.print("pizza is on the way!");
	}
	
}
class burger implements food{

	@Override
	public void prepare() {
		System.out.print("burger is on the way!");
	}
	
}
class pasta implements food{

	@Override
	public void prepare() {
		
		System.out.print("pasta is on the way!");
	}
	
}
interface sideFood{
	abstract void get_sideDish();
}
class frenchFries implements sideFood{

	@Override
	public void get_sideDish() {
		System.out.println("french fries ready!");
	}
	
}
class drinks implements sideFood{

	@Override
	public void get_sideDish() {
		System.out.println("drinks ready!");
	}
	
}
abstract class foodfactory{
	abstract food get_food();
	abstract sideFood get_sideDish();
	
}

class pizzafactory extends foodfactory{

	@Override
	food get_food() {
		return new pizza();
	}

	@Override
	sideFood get_sideDish() {
	
		return new frenchFries() ;
	}

}
class burgerfactory extends foodfactory{

	@Override
	food get_food() {
		return new burger();
	}

	@Override
	sideFood get_sideDish() {
		// TODO Auto-generated method stub
		return new frenchFries();
	}

}
class pastafactory extends foodfactory{

	@Override
	food get_food() {
		return new pasta();
	}

	@Override
	sideFood get_sideDish() {
		// TODO Auto-generated method stub
		return new drinks();
	}

}
public class FoodApp {
	
	public static void main(String[]args)
	{
		foodfactory food=new pizzafactory();
		food main_dish=food.get_food();
		sideFood side_dish=food.get_sideDish();
		main_dish.prepare();
		side_dish.get_sideDish();
		
		
	} 
	// grouping multiple objects of same family is abstract factory design pattern.
}
