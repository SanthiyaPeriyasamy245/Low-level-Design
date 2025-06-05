package FactoryDesignPattern;

public class SmsNotificationSender extends NotificationCreator {

	@Override
	public Notification CreateNotification() {
		
		return new SmsNotification();
	}

}
