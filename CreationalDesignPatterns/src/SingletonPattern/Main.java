package SingletonPattern;

public class Main {

	
	/* Singleton Pattern is a creational design pattern 
	 that guarantees a class has only one instance 
	 and provides a global point of access to it
	*/
	public static void main(String[] args) {
		
		
		/*
		 * Singleton Pattern :
Real-World Examples of Singleton Design Pattern
Singleton is useful in scenarios like:

Managing Shared Resources (database connections, thread pools, caches, configuration settings)

Coordinating System-Wide Actions (logging, print spoolers, file managers)

Managing State (user session, application state)
		  
		 * */
		
		LazySingleton obj1=LazySingleton.object();
		LazySingleton obj2=LazySingleton.object();
		
		ThreadSafeSingleton  obj3=ThreadSafeSingleton.getObj();
		ThreadSafeSingleton  obj4=ThreadSafeSingleton.getObj();
		
		DoubleCheckLockingSingleton obj5=DoubleCheckLockingSingleton.getObj();
		DoubleCheckLockingSingleton obj6=DoubleCheckLockingSingleton.getObj();
		
		StaticInitialization obj7=StaticInitialization.getObj();
		StaticInitialization obj8=StaticInitialization.getObj();
		
		BillPughSingleton obj11=BillPughSingleton.getObj();
		
		BillPughSingleton obj12=BillPughSingleton.getObj();
		
		System.out.println(obj11);
		System.out.println(obj12);
		
		
		// lazy singleton pattern
		System.out.println(obj1);
		System.out.println(obj2);
		
		// thread safe singleton
		System.out.println(obj3);
		System.out.println(obj4);
		
		//DoubleCheckLockingSingleton
		System.out.println(obj5);
		System.out.println(obj6);
		
		System.out.println(obj7);
		System.out.println(obj8);
		
		/*
		 * Specific Examples:
Logger Classes: Many logging frameworks use the Singleton pattern to provide a global logging object. This ensures that log messages are consistently handled and written to the same output stream.

Database Connection Pools: Connection pools help manage and reuse database connections efficiently. A Singleton can ensure that only one pool is created and used throughout the application.

Cache Objects: In-memory caches are often implemented as Singletons to provide a single point of access for cached data across the application.

Thread Pools: Thread pools manage a collection of worker threads. A Singleton ensures that the same pool is used throughout the application, preventing resource overuse.

File System: File systems often use Singleton objects to represent the file system and provide a unified interface for file operations.

Print Spooler: In operating systems, print spoolers manage printing tasks. A single instance coordinates all print jobs to prevent conflicts*/
	}

}
