package FactoryDesignPattern;

public class Main {
	
	public static void main(String[]args)
	{
		NotificationCreator creator;
		creator=new EmailNotificationSender();
		creator.send("Welcome to mail !");
		
		creator=new SmsNotificationSender();
		creator.send("Welcome to sms !");
	}

}
