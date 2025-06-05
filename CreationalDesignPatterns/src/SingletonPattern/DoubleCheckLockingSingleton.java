package SingletonPattern;

public class DoubleCheckLockingSingleton {
	
	private static volatile DoubleCheckLockingSingleton singleton;
	
	private DoubleCheckLockingSingleton() {}
	
	
	public static DoubleCheckLockingSingleton getObj()
	{
		if(singleton==null)	
		{
			synchronized(DoubleCheckLockingSingleton.class)
			{
				
			if(singleton==null)
			{
			singleton=new DoubleCheckLockingSingleton();
			}
			}
		}
		
		return singleton;
	}

}
