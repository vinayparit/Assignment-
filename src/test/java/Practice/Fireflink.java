package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Fireflink {

	@Test
	public void login()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.fireflink.com/");
		
		driver.findElement(By.cssSelector("[class=\"sign_in btn btn-outline-primary\"]")).click();
		driver.findElement(By.id("emailId")).sendKeys("vp02work@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Vinay@123");
		driver.findElement(By.cssSelector("[class=\"signup_orange_button signing_in\"]")).click();
		driver.findElement(By.cssSelector("[alt=\"fireFlinkPlatform\"]")).click();
		
	}
}
