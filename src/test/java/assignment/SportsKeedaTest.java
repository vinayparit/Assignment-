package assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SportsKeedaTest {

	WebDriver driver = null;

	@Test
	public void sportsKeeda() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String expPosition = "5";
		driver.get("https://www.sportskeeda.com/");
		driver.findElement(By.xpath("//span[.='Full Table']")).click();

		ArrayList<String> num = new ArrayList<String>();
		List<WebElement> rowNum = driver
				.findElements(By.xpath("//table[@class=\"keeda-data-table\"]/tbody/tr/td[1]/div[@class=\"ta-c\"]"));
		for (WebElement row : rowNum) {
			num.add(row.getText());
		}

		ArrayList<String> arr = new ArrayList<String>();
		List<WebElement> data = driver.findElements(By.xpath("//table[@class=\"keeda-data-table\"]/tbody/tr"));
		for (WebElement info : data) {
			arr.add(info.getText());
		}

		HashMap<String, String> map = new HashMap<String, String>();

		for (int i = 0; i < rowNum.size(); i++) {
			map.put(num.get(i), arr.get(i));
		}
		for (Entry<String, String> entry : map.entrySet()) {
			if (entry.getKey().equals(expPosition)) {
				System.out.println(entry.getKey() + ":" + entry.getValue());
			}
		}
	}
}
