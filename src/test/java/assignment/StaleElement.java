package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class StaleElement {

	@Test
	public void googleDoodleTest() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.get("https://omayo.blogspot.com/");
		WebElement textArea = driver.findElement(By.id("ta1"));

		textArea.sendKeys("Hi Hello");
		driver.findElement(By.linkText("compendiumdev")).click();

		driver.navigate().back();
		textArea = driver.findElement(By.id("ta1"));

//		if (wait.until(ExpectedConditions.stalenessOf(textArea)) == false) {
//			textArea.clear();
//		} else {
//			wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(textArea)));
//			textArea.clear();
//		}

		// To avoid staleelementreference excep
		try{
			textArea.clear();
		}
		catch (StaleElementReferenceException s) {
			textArea=driver.findElement(By.id("ta1"));
			textArea.clear();
		}
		catch (WebDriverException web) {
			web.printStackTrace();
		}

	}
}
