package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.Assignment.GenricUtility.WebDriverUtils;

public class AddToCartTest {

	
	@Test
	public void addToCart()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.flipkart.com/");
		WebElement searchBar=driver.findElement(By.xpath("//input[@placeholder=\"Search for Products, Brands and More\"]"));
		searchBar .sendKeys("iphone");
		driver.findElement(By.xpath("//button[@aria-label=\"Search for Products, Brands and More\"]")).click();
		driver.findElement(By.xpath("//div[@class=\"_4rR01T\" and contains(.,'Apple iPhone 14 (Starlight, 128 GB)')]")).click();
		
		WebDriverUtils wLib=new WebDriverUtils();
		
		String expTitle="APPLE iPhone 14 ( 128 GB Storage ) Online at Best Price On Flipkart.com";
		wLib.switchToWindow(driver,expTitle);
		driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2U9uOA _3v1-ww\"]")).click();
		driver.close();
		
		String parent="Iphone- Buy Products Online at Best Price in India - All Categories | Flipkart.com"; 
		wLib.switchToWindow(driver, parent);
		WebElement searchBarP=driver.findElement(By.xpath("//input[@placeholder=\"Search for products, brands and more\" and contains(@value,\"iphone\")]"));
		searchBarP.clear();
		searchBarP.sendKeys("samsung");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	}
}
