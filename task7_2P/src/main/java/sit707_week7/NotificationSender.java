package sit707_week7;

public interface NotificationSender {

	/**
	 * Notify customer him/herself of a message.
	 * @param b
	 * @param msg
	 */
	public void sendEmailNotification(boolean b, String msg);
	
	/**
	 * Notify family physician alert message.
	 * @param familyDoctor
	 * @param msg
	 */
	public void sendEmailNotification(FamilyDoctor familyDoctor, String msg);

	public void sendEmailNotification(Customer fixedCustomer, String msg);
}
