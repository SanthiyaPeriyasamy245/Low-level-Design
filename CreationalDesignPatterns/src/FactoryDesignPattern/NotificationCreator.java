package FactoryDesignPattern;

public abstract class NotificationCreator {
	public abstract Notification CreateNotification();
	
	// common logic 
	public void send(String message)
	{
		Notification notification=CreateNotification();
		notification.send(message);
	}
	

}
