package assignment;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DigiKeyTest {
	WebDriver driver = null;

	@Test(invocationCount = 5)
	public void login() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Actions act = new Actions(driver);

		driver.get("https://www.digikey.in/");
//		WebElement clickAndhold = driver.findElement(By.cssSelector("[aria-label=\"Click & Hold\"]"));
//		act.clickAndHold(clickAndhold).perform();

		WebElement login = driver
				.findElement(By.xpath("//div[@class=\"flymenu__pin flymenu__my-account flymenu__section\"]"));
		act.moveToElement(login).perform();
		assertTrue(true);
		driver.quit();
	}
}
