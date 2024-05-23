package sit707_week7;

public interface CloudService {

	/**
	 * Report temperature value to server.
	 * @param d
	 */
	public void sendTemperatureToCloud(double d);
	
	/**
	 * Inquire customer body status based on temperature.
	 * @param fixedCustomer
	 * @return Status string - NORMAL, ABNORMAL
	 */
	public String queryCustomerBodyStatus(Customer fixedCustomer);

	public Object queryCustomerBodyStatus(boolean anyBoolean);
}
