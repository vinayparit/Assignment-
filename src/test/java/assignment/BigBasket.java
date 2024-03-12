package assignment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class BigBasket {

	@Test
	public void bigBasket() throws AWTException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions action = new Actions(driver);

		driver.get("https://www.bigbasket.com/");
		Robot r = new Robot();
		try {
			for (int i = 0; i <= 3; i++) {
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_MINUS);
				r.keyRelease(KeyEvent.VK_CONTROL);
				r.keyRelease(KeyEvent.VK_MINUS);

			}
		} catch (Exception e) {
			r.keyPress(KeyEvent.VK_MINUS);
			r.keyRelease(KeyEvent.VK_MINUS);
		}
		driver.findElement(By.xpath("//button[@id=\"headlessui-menu-button-:R5bab6:\"]")).click();

		List<WebElement> main = driver.findElements(By.xpath(
				"//div[@id='headlessui-menu-items-:R9bab6:']/descendant::ul[@class='jsx-1259984711 w-56 px-2.5 bg-darkOnyx-800 text-silverSurfer-100 rounded-l-xs']/child::li[@class='jsx-1259984711']"));
		int i = 0;
		for (WebElement ref : main) {

			action.moveToElement(ref).perform();
			List<WebElement> sub1 = driver.findElements(By.xpath(
					"//div[@id='headlessui-menu-items-:R9bab6:']/descendant::ul[@class=\"jsx-1259984711 w-56 px-2.5 bg-silverSurfer-200 text-darkOnyx-800\"]/child::li[@class=\"jsx-1259984711\"]"));
			for (WebElement subEle : sub1) {
				action.moveToElement(subEle).perform();
				System.out.println(subEle.getText());
				System.out.println("----------------");
				List<WebElement> subMenu = driver.findElements(By.xpath(
						"//li[@class=\"jsx-1259984711\"]/ancestor::div[@id='headlessui-menu-items-:R9bab6:']/descendant::ul[@class=\"jsx-1259984711 w-56 px-2.5 bg-white text-darkOnyx-800 rounded-r-xs\"]"));

				for (WebElement subMenuEle : subMenu) {

					System.out.println(subMenuEle.getText());
					System.out.println();

				}

			}

		}

	}
}
