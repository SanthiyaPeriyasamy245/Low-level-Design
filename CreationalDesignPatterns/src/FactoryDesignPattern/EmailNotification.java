package FactoryDesignPattern;

public class EmailNotification  implements Notification {

	@Override
	public void send(String message) {
		
		System.out.print("Email Notifaction" + " " + message);
		
	}

}
