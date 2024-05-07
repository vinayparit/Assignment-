package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Amazon {

	WebDriver driver = null;

	@Test
	public void login() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.get("https://www.amazon.in/");
		WebElement account = driver.findElement(By.cssSelector("[id=\"nav-link-accountList\"]"));

		act.moveToElement(account);

		driver.findElement(By.cssSelector("[id=\"nav-signin-tooltip\"]")).click();
		driver.findElement(By.cssSelector("[id=\"ap_email\"]")).sendKeys("7204469689" + Keys.ENTER);
		driver.findElement(By.cssSelector("[id=\"ap_password\"]")).sendKeys("Kanmani@19" + Keys.ENTER);
		driver.navigate().refresh();
		WebElement account1 = driver.findElement(By.id("nav-link-accountList"));
		wait.until(ExpectedConditions.elementToBeClickable(account));
		
		act.moveToElement(account1).perform();
		Thread.sleep(3000);
		String exp = "Your orders";
		List<WebElement> list = driver.findElements(By.cssSelector("[id=\"nav-al-your-account\"]"));
		for (WebElement e : list) {
			String details = e.getText();
			System.out.println(details);
			if (details.contains(exp)) {
				e.click();
			}
		}
	}
}
