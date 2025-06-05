package FactoryDesignPattern;

public class EmailNotificationSender extends NotificationCreator {

	@Override
	public Notification CreateNotification() {
		
		return new EmailNotification();
	}

}
