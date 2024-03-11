package assignment;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoIbibo {

	@Test
	public void goIbibo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[@role=\"presentation\"]")).click();
		WebElement from = driver
				.findElement(By.xpath("//span[.=\"From\"]/following-sibling::p[.='Enter city or airport']"));
		from.click();
		driver.findElement(By.xpath("//span[@class=\"sc-12foipm-39 hRfNRh\"]/following-sibling::input[@type=\"text\"]"))
				.sendKeys("abc");
//		from.sendKeys("abc");

	}
}
