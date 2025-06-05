package FactoryDesignPattern;

public class PushNotificationSender extends NotificationCreator {

	@Override
	public Notification CreateNotification() {
		
		return new PushNotification();
	}

}
