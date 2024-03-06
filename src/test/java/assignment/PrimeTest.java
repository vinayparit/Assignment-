package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class PrimeTest {

	@Test
	public void primeTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions action = new Actions(driver);

		driver.get("https://www.primevideo.com/offers/nonprimehomepage/ref=dv_web_force_root");
		WebElement home = driver.findElement(By.xpath("//label[@for=\"pv-nav-home\"]"));
		action.moveToElement(home).perform();
		driver.findElement(By.xpath("//a[.='Movies']")).click();
//		List<WebElement> actionMovies = driver.findElements(By.xpath("//a[@class=\"_3HZFFn\"]"));
		List<WebElement> mov = driver.findElements(By.xpath("//p[.='Action and adventure movies']/ancestor::section[@data-testid=\"standard-carousel\"]/descendant::ul[@class=\"_70Gje9\"]/li[@class=\"tHfREs\"]"));
		int i = 0;
		for (WebElement ele : mov) {
			action.scrollToElement(ele).perform();
//			String movieNames = ele.getText();
			System.out.println(mov.get(i).getText());
			i++;

		}
	}
}
