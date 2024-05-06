package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Make {

	@Test
	public void click() throws InterruptedException
	{
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--incongnito");
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.makemytrip.com/");
		Actions act = new Actions(driver);
		act.doubleClick().click().perform();
		Thread.sleep(3000);

		act.moveByOffset(50, 50).click().perform();
		Mmt clk=new Mmt();
		driver.findElement(By.xpath("//span[.='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"From\"]")).sendKeys("mumbai");
		driver.findElement(By.xpath("//p[.='Mumbai, India']")).click();
		driver.findElement(By.xpath("//span[.='To']")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"To\"]")).sendKeys("bangalore");
		driver.findElement(By.xpath("//p[.='Bengaluru, India']")).click();
		driver.findElement(By.xpath("//span[.='Departure']"));
		clk.date(driver, "May 2024","5" );
		driver.findElement(By.xpath("//a[.='Search']")).click();
		
	}
}
