package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BookMyShow {

	@Test
	public void bookMyShow() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));

		driver.get("https://bookmyshow.com/");
		driver.findElement(By.xpath("//img[@alt=\"BANG\"]")).click();
		driver.findElement(By.xpath("//img[@alt=\"Dune: Part Two\"]")).click();
//		driver.findElement(By.xpath("//div[@class='sc-qswwm9-5 ghYvew']/descendant::span[.='Book tickets']")).click();
//		WebElement d2=driver.findElement(By.xpath("//div[@class='sc-qswwm9-5 ghYvew']/descendant::span[.='Book tickets']"));
//		wait.until(ExpectedConditions.elementToBeClickable(d2));
//		d2.click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='sc-qswwm9-5 ghYvew']/descendant::span[.='Book tickets']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//section[@class=\"sc-vhz3gb-1 gyUIdc\" and contains(.,'English')]/following-sibling::section/div/span[.='2D']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
		
		driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
	}
}
