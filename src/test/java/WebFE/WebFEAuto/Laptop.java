package WebFE.WebFEAuto;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import PageObjects.HomePageOBjects;
import PageObjects.LaptopItemsPageOBjects;
import PageObjects.OrderCartPageOBjects;
import PageObjects.PlaceOrderPageOBjects;
import Resources.Base;


public class Laptop extends Base
{
	
 //Variables//
	public String text;
	public String LaptopPrice;
	public String[] amounttoget; 
	public String laptopamount="";
	public int i=0,j=0;
	public char ch=' ';
	public String OrderAmount="";
	public static Logger log =LogManager.getLogger(Base.class.getName());  
	
	@Test
	public void driver() throws IOException
	
	{
		driver=initializedriver();											 
		
	}
	
	
	@Test(priority=1)
	public void homepage() throws  AWTException, InterruptedException 
	
	{
		HomePageOBjects lpb = new HomePageOBjects(driver);
		OrderCartPageOBjects ocpo = new OrderCartPageOBjects(driver);
		PlaceOrderPageOBjects ppo= new PlaceOrderPageOBjects(driver);
		LaptopItemsPageOBjects lipo = new LaptopItemsPageOBjects(driver);
		
		
		driver.get(prop.getProperty("url"));                                
		driver.manage().window().maximize();                                 
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);  	 
		
		
		lpb.laptoplinkclick().click();
		lipo.Sonylaptop().click();
		LaptopPrice=lipo.SonylaptopPrice().getText();
		lipo.AddtoCartButton().click();
		
		Thread.sleep(2000);
		
		Robot r = new Robot();
		
		r.keyPress(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		
		driver.get("https://www.demoblaze.com/index.html");
		lpb.laptoplinkclick().click();
		lipo.Delllaptop().click();
		lipo.AddtoCartButton().click();

				
		r.keyPress(KeyEvent.VK_ENTER);
		lipo.CartButton().click();
		
		Thread.sleep(2000);
		
		if (prop.getProperty("Laptop").equalsIgnoreCase("Dell"))
		{
			ocpo.Delete1().click();
		}
		
		else
			
		{
			ocpo.Delete2().click();
		}
		
		Thread.sleep(2000);
		
		ppo.PlaceOrder().click();		
		ppo.FormName().sendKeys(prop.getProperty("FormName"));
		ppo.FormCountry().sendKeys(prop.getProperty("FormCountry"));
		ppo.FormCity().sendKeys(prop.getProperty("FormCity"));
		ppo.FormCard().sendKeys(prop.getProperty("FormCard"));
		ppo.FormMonth().sendKeys(prop.getProperty("FormMonth"));
		ppo.FormYear().sendKeys(prop.getProperty("FormYear"));
		ppo.FormPurchaseOrder().click();
		text=ppo.OrderDetailsView().getText();
		
		log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		log.info("Order details are as follows -->");
		log.info(text);
		log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
	}
	
	@Test(priority=2)
	public void compare()
	{
		
		amounttoget =text.split(":");
		
		for (i=0;i<amounttoget.length;i++)
		{	
			laptopamount=amounttoget[2];
		}
		for (j=0;j<laptopamount.length();j++)
		{
			ch=laptopamount.charAt(j);
		if (Character.isDigit(ch))
		{
			OrderAmount=OrderAmount+ch;
		}
		}
		
		log.info("The expected amount for the laptop is-->"+LaptopPrice);
		log.info("The purchase amount for the laptop is-->"+OrderAmount+" USD");
		
	}
	
	@AfterTest
	public void closebrowser()
	
	{
		driver.quit();
		driver=null;                                                                       
	}
	

}
