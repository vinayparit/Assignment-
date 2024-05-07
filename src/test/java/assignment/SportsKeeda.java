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

public class SportsKeeda {

	WebDriver driver = null;

	@Test
	public void pointsTable() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.sportskeeda.com/");

//Complete Table
		driver.findElement(By.xpath("//span[.='Full Table']")).click();
//Each element of row
		List<WebElement> pointsTable = driver
				.findElements(By.xpath("//table[@class=\"keeda-data-table\"]/tbody/tr[*]"));
		int size = pointsTable.size();
//1st row	
		ArrayList<String> num=new ArrayList<String>();
		List<WebElement> rowNum = driver
				.findElements(By.xpath("//table[@class=\"keeda-data-table\"]/tbody/tr/td[1]/div[@class=\"ta-c\"]"));
		for (WebElement row : rowNum) {
			num.add(row.getText());
		} 

		for (int i = 0; i < size; i++) {
//Create hashmap to store all the data
			HashMap<String, List> map = new HashMap<>();

			List<WebElement> details = driver
					.findElements(By.xpath("//table[@class=\"keeda-data-table\"]/tbody/tr[" + (i + 1) + "]/td[*]"));

			ArrayList<String> arr = new ArrayList<String>();
			for (int j = 0; j < details.size(); j++) {
				arr.add(details.get(j).getText());

			}
			map.put(rowNum.get(i).getText(), arr);
			System.out.println(map);
		}

	}

}
