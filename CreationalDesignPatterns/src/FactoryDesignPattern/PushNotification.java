package FactoryDesignPattern;

public class PushNotification implements Notification{

	@Override
	public void send(String message) {
		
		System.out.print("Push Notifaction" +message);
		
	}

}
