package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Youtube {

	@Test
	public void youtube() throws InterruptedException
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--incognito");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.youtube.com/");
//		String text = driver.switchTo().activeElement().getText();
//		System.out.println(text);
//		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id=\"search\"]")).sendKeys("song");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id=\"search\"]")).sendKeys(" ");
	}
}
