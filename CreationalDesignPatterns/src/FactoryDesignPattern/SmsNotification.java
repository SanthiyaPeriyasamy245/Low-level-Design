package FactoryDesignPattern;

public class SmsNotification implements Notification{

	@Override
	public void send(String message) {
		
		System.out.print("SMS Notifaction" +message);
		
	}
	
	
}
