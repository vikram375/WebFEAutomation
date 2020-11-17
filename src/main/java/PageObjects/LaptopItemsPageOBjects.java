package PageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LaptopItemsPageOBjects
{


	public WebDriver driver=null;
	
	By SonyLaptop= By.linkText("Sony vaio i5"); 
	By SonyLaptopPrice =By.xpath("//*[@id='tbodyid']/h3");
	By DellLaptop= By.linkText("Dell i7 8gb"); 	
	By AddToCart= By.linkText("Add to cart"); 	
	By Cart= By.linkText("Cart"); 	
	

	public LaptopItemsPageOBjects(WebDriver driver)
	
	{
		this.driver=driver;
	}
	

	public WebElement Sonylaptop()
	
	{
		return driver.findElement(SonyLaptop);
	
	}
	public WebElement SonylaptopPrice()
	
	{
		return driver.findElement(SonyLaptopPrice);
	
	}
	public WebElement Delllaptop()
		
	{
		return driver.findElement(DellLaptop);
	
	}
	public WebElement AddtoCartButton()
	
	{
		return driver.findElement(AddToCart);
	
	}
	
	public WebElement CartButton()
	
	{
		return driver.findElement(Cart);
	
	}


	
	

}
