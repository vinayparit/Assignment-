package assignment;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Amazon {

	WebDriver driver = null;

	@Test
	public void login() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions act = new Actions(driver);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.get("https://www.amazon.in/");
		WebElement account = driver.findElement(By.cssSelector("[id=\"nav-link-accountList\"]"));

		act.moveToElement(account);

		driver.findElement(By.cssSelector("[id=\"nav-signin-tooltip\"]")).click();
		driver.findElement(By.cssSelector("[id=\"ap_email\"]")).sendKeys("vinayparit@gmail.com" + Keys.ENTER);
		driver.findElement(By.cssSelector("[id=\"ap_password\"]")).sendKeys("Kanmani@19" + Keys.ENTER);
		driver.findElement(By.xpath("//a[@class=\"nav-a  \" and contains(.,'Coupons')]")).click();

		driver.findElement(By.xpath("//a[@id=\"vpc-coupon-bar-clipped-coupon-link\"]")).click();
		driver.findElement(By
				.xpath("//a[@href=\"/promotion/psp/A314WFYC2XKSAO\"]/parent::div[@class=\"a-section coupon-clipped\"]"))
				.click();
		WebElement promo = driver.findElement(By.cssSelector("[id=\"promotionTitle\"]"));

		System.out.println(promo.getText());

	}
}
