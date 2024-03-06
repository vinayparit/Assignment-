package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SpiceJetTest {

	@Test
	public void spiceJetTest() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions action = new Actions(driver);

		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath(
				"//div[.='round trip']/parent::div[@data-testid=\"round-trip-radio-button\"]/child::div[@class=\"css-1dbjc4n r-zso239\"]"))
				.click();
		WebElement from = driver.findElement(By.xpath("//div[@data-testid=\"to-testID-origin\"]"));
		action.click(from).perform();
		action.sendKeys(from, "mu").perform();
		driver.findElement(By.xpath("//div[@class=\"css-76zvg2 r-cqee49 r-ubezar r-1kfrs79\" and .='Mumbai']")).click();
		driver.switchTo().activeElement().sendKeys("ban");
		driver.findElement(By.xpath("//div[@class=\"css-76zvg2 r-cqee49 r-ubezar r-1kfrs79\" and .='Bengaluru']"))
				.click();
		driver.findElement(By.xpath(
				"//div[@data-testid=\"undefined-month-February-2024\" and contains(.,'28')]/descendant::div[@data-testid=\"undefined-calendar-day-28\"]"))
				.click();
		driver.findElement(By.xpath(
				"//div[@data-testid=\"undefined-month-April-2024\" and contains(.,'3')]/descendant::div[@data-testid=\"undefined-calendar-day-3\"]"))
				.click();
		WebElement passenger = driver.findElement(By.xpath(
				"//div[@class=\"css-76zvg2 css-bfa6kz r-1862ga2 r-1gkfh8e\" and .='Passengers']/parent::div[@data-testid=\"home-page-travellers\"]/descendant::div[@class=\"css-76zvg2 css-bfa6kz r-homxoj r-ubezar\"]"));
		passenger.click();
		driver.findElement(By.xpath("//div[@data-testid=\"Adult-testID-plus-one-cta\"]")).click();
		passenger.click();
		driver.findElement(By.xpath("//div[@data-testid=\"home-page-flight-cta\"]")).click();
	}
}
