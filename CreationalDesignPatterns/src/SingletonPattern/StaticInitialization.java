package SingletonPattern;

public class StaticInitialization {
	
	private static StaticInitialization singleton;
	
	private StaticInitialization() {}
	
	static {
		
			try {
				singleton=new StaticInitialization();
			} catch (Exception e) {
				System.out.println("Error occured while creating object!");
			}
	}
	public static StaticInitialization getObj()
	{
		return singleton;
	}

}
