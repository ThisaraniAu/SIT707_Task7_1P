package sit707_week7;

public class TemperatureReading {
	
	// Customer object
	private Customer customer;
	
	// reading time string format hh:mm:ss
	private String readingTime;
	
	// Body temperature
	private double bodyTemperature;
	
	// Constructors, getters, and setters
    public TemperatureReading() {}

    public TemperatureReading(Customer customer, String readingTime, double bodyTemperature) {
        this.customer = customer;
        this.readingTime = readingTime;
        this.bodyTemperature = bodyTemperature;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getReadingTime() {
        return readingTime;
    }

    public void setReadingTime(String readingTime) {
        this.readingTime = readingTime;
    }

    public double getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(double bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }
}
