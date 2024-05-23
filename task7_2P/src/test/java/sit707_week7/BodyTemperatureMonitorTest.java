package sit707_week7;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BodyTemperatureMonitorTest {
    private TemperatureSensor temperatureSensor;
    private CloudService cloudService;
    private NotificationSender notificationSender;
    private BodyTemperatureMonitor monitor;
    
    @Before
    public void setUp() {
        temperatureSensor = Mockito.mock(TemperatureSensor.class);
        cloudService = Mockito.mock(CloudService.class);
        notificationSender = Mockito.mock(NotificationSender.class);
        monitor = new BodyTemperatureMonitor(temperatureSensor, cloudService, notificationSender);
    }

	@Test
	public void testStudentIdentity() {
		String studentId = "s224137768";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Thisarani Jayawardhana";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
	public void testReadTemperatureNegative() {
		 Mockito.when(temperatureSensor.readTemperatureValue()).thenReturn(-5.0);
	        double temperature = monitor.readTemperature();
	        Assert.assertEquals(-5.0, temperature, 0.01);
	}
	
	@Test
	public void testReadTemperatureZero() {
		Mockito.when(temperatureSensor.readTemperatureValue()).thenReturn(0.0);
        double temperature = monitor.readTemperature();
        Assert.assertEquals(0.0, temperature, 0.01);
       
	}
	
	@Test
	public void testReadTemperatureNormal() {
		  Mockito.when(temperatureSensor.readTemperatureValue()).thenReturn(36.6);
	        double temperature = monitor.readTemperature();
	        Assert.assertEquals(36.6, temperature, 0.01);
		
	}

	@Test
	public void testReadTemperatureAbnormallyHigh() {
		 Mockito.when(temperatureSensor.readTemperatureValue()).thenReturn(42.0);
	        double temperature = monitor.readTemperature();
	        Assert.assertEquals(42.0, temperature, 0.01);
	        
	}

	@Test
	 public void testReportTemperatureReadingToCloud() {
        monitor.reportTemperatureReadingToCloud(null);
        Mockito.verify(cloudService, Mockito.times(1)).sendTemperatureToCloud(Mockito.anyDouble());
    }
	
	
	
	public void testInquireBodyStatusNormalNotification() {
        // Mock the behavior of the cloud service to return "NORMAL"
        Mockito.when(cloudService.queryCustomerBodyStatus(Mockito.anyBoolean())).thenReturn("NORMAL");
        
        // Call the method under test
        monitor.inquireBodyStatus();
        
        // Verify that the notification sender was called with the correct parameters
        Mockito.verify(notificationSender, Mockito.times(1)).sendEmailNotification(
                Mockito.eq(false), // Fixed customer
                Mockito.eq("Thumbs Up!")
        );
        
        // Verify that the notification sender was not called for the family doctor
        Mockito.verify(notificationSender, Mockito.never()).sendEmailNotification(
                Mockito.eq(true), // Family doctor
                Mockito.anyString()
        );
    }

 
}
