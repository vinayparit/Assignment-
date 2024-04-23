package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class IxigoTest {

	@Test
	public void ixigoTest() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions action = new Actions(driver);

		driver.get("https://www.ixigo.com/flights");
		WebElement clk = driver.findElement(By.xpath("//p[@data-testid=\"originId\"]"));
//		action.click(clk).perform();
//		clk.sendKeys("Mumbai");
		action.sendKeys(clk, "mumbai").perform();
//		action.click(clk).perform();
//		driver.navigate().refresh();
//		driver.findElement(By.xpath("//input[contains(@value,'Bengaluru')]")).clear();
//		wait.until(ExpectedConditions.elementToBeClickable(click));
//		driver.switchTo().activeElement().sendKeys("mumbai");
		
		
		WebElement to=driver.findElement(By.cssSelector("[data-testid=\"destinationId\"]"));
		action.doubleClick(to).perform();
//		to.sendKeys("bangalore");

	}
}
