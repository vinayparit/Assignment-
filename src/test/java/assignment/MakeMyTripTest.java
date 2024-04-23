package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MakeMyTripTest {

	@Test
	public void booking() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		driver.get("https://www.makemytrip.com/");
//		driver.findElement(By.cssSelector("[data-cy=\"takeMeToHomeDT\"]")).click();
		driver.findElement(By.cssSelector("[data-cy=\"closeModal\"]")).click();

		driver.findElement(By.xpath("//span[.='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"From\"]")).sendKeys("bang");

		List<WebElement> from = driver
				.findElements(By.cssSelector(""));
//		String frm="Bengaluru,India";
		for (WebElement click : from) {
			String sug = click.getText();
			System.out.println(sug);
			System.out.println("---------------");
			if (sug.contains("Bengaluru"))
				click.click();
			break;

		}

		driver.findElement(By.xpath("//span[.='To']")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"To\"]")).sendKeys("chen");

		List<WebElement> to = driver
				.findElements(By.xpath("//li[contains(@id,\"react-autowhatever\")]"));
		for (WebElement chen : to) {
			String sugges = chen.getText();
			System.out.println(sugges);
			if (sugges.contains("Chenn"))
				chen.click();
			break;
		}
		

	}
}
