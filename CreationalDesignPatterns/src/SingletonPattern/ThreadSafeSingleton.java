package SingletonPattern;

public class ThreadSafeSingleton {
	
	private static ThreadSafeSingleton singleton;
	
	private ThreadSafeSingleton() {}
	public static synchronized ThreadSafeSingleton getObj()
	{
		if(singleton==null)
		{
			singleton=new ThreadSafeSingleton();
		}
		return singleton;
	}
	

}
