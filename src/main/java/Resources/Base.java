package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Base 

{
	
	public static  WebDriver driver;  
	public static  Properties prop;

	
	
	
	public static WebDriver initializedriver() throws IOException  
	
	{
	 prop = new Properties();
	
	FileInputStream fis = new FileInputStream("configs//Data.Properties");
	
	prop.load(fis);
	
	prop.getProperty("browser");
	
	String browsername=prop.getProperty("browser");
	
		if (browsername.equals("chrome"))
				
			{
				
				System.setProperty("webdriver.chrome.driver", "configs//chromedriver.exe");
				
				driver= new ChromeDriver();
					
			}
			
		
		else if (browsername.equals("firefox"))
				
			{
				System.setProperty("webdriver.gecko.driver", "configs//geckodriver.exe");
				
				 driver= new FirefoxDriver();
				
			}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		return driver;
	
	}
	

	
}	

