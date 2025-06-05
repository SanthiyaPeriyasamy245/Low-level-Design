package SingletonPattern;

public class EagerInitialization {
	
	/*
	 In this method, we rely on the JVM to create the singleton instance
	  when the class is loaded. The JVM guarantees 
	 that the instance will be created 
	 before any thread access the instance variable.
	 */
	
	private static EagerInitialization singleton=new EagerInitialization();
	private EagerInitialization() {}
	public static EagerInitialization getObj()
	{
		return singleton;
	}

}
