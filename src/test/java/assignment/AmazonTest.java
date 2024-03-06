package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AmazonTest {

	@Test
	public void amazonTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung mobiles");
		driver.findElement(By.id("nav-search-submit-text")).click();
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class=\"a-price-whole\"]"));
		List<WebElement> p = driver
				.findElements(By.xpath("//span[@class=\"a-size-medium a-color-base a-text-normal\"]"));
		int i = 0;
		for (WebElement ref : prices) {
			String pri = ref.getText().replace(",", "");
			Integer price = Integer.parseInt(pri);

			if (price <= 20000 ) {
				System.out.println(p.get(i).getText() + "------->" + price);
			}
			i++;
		}
		System.out.println(i);
	}
}
