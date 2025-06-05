package SingletonPattern;

public class BillPughSingleton {
	
	private BillPughSingleton()
	{	
	}
	private static class helper{
		private static final BillPughSingleton obj=new BillPughSingleton();
		
		
	}
	public static BillPughSingleton getObj()
	{
		return helper.obj;
	}

}
