package Builder;

class Main{
	public static void main(String[]args)
	{
		Phone phone=new Phone.CreatePhone(4, 16).addScreenSize("small").addBattery(112).build();
		System.out.println(phone);
		Phone phone1=new Phone.CreatePhone(5, 10).addBattery(200).build();
		System.out.println(phone1);
		
	    // builder design pattern is used to create an object step by step.
	   // as per requirements object creation done accordingly.
	
	}
}
