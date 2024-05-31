package assignment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Assignment.GenricUtility.JavaUtils;

public class Interview {

	@org.testng.annotations.Test
	public void Test() throws AWTException, IOException {
		
		String localDateTime = LocalDateTime.now().toString().replace(":", "-");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20)); 
		driver.get("https://www.google.com/");
		
		driver.findElement(By.cssSelector("[aria-label=\"Search\"]")).sendKeys("Vinay"+Keys.ENTER);
			
		Actions action=new Actions(driver);
		
		
//		WebDriverWait wait=new WebDriverWait(driver, Duration.of)
		List<WebElement> names = driver.findElements(By.xpath("//*[contains(.,'Vinay')]"));
//		for (WebElement we : names) {
//			
//			action.moveToElement(we).perform();
//			
//		}
		action.scrollByAmount(0, 50000).perform();
		System.out.println(names.size());
		if(names.size()>50000)
		{
			System.out.println("Pass");
		}
		else
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dst = new File(".\\Assignments\\ScreenShot"+localDateTime+".png");
			FileUtils.copyFile(src, dst);
			System.out.println("Fail");
		}
		}
}
