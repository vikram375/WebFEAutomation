package PageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderCartPageOBjects
{

	public WebDriver driver=null;
	
	By DeleteButton1= By.xpath("//*[@id='tbodyid']/tr[2]/td[4]/a");		
	By DeleteButton2= By.xpath("//*[@id='tbodyid']/tr[1]/td[4]/a");	

	public OrderCartPageOBjects(WebDriver driver)
	
	{
		this.driver=driver;
	}
	

	public WebElement Delete1()
	
	{
		return driver.findElement(DeleteButton1);
	
	}
	public WebElement Delete2()
	
	{
		return driver.findElement(DeleteButton2);
	
	}


	
	

}
