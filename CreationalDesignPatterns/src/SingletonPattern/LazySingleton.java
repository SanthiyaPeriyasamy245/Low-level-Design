package SingletonPattern;

/* 1. Lazy Initialization
This approach creates the singleton instance only when it is needed, 
saving resources if the singleton is never used in the application.
*/
public class LazySingleton {

	private static LazySingleton singleton;
	
	private LazySingleton(){}
	
	public static LazySingleton object()
	{
		if(singleton==null)
		{
			singleton=new LazySingleton();
		}
		return singleton;
	}
}
