package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CovidTest {

	@Test

	public void covidTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://data.who.int/dashboards/covid19/cases?n=c");

		List<WebElement> graphList = driver.findElements(By.xpath(
				"//*[local-name()='svg' and @aria-label=\"Chart displaying 215 EPI Weeks from 5 Jan 2020 till 11 Feb 2024.\"] [1]//*[name()='text' and @role=\"listitem\"]"));
		Actions act=new Actions(driver);
		for(WebElement e:graphList)
		{
			
			act.moveToElement(e).perform();
			String cases=e.getAttribute("x");
			String date=e.getText();
			System.out.println(date+ " Number of cases in graph: " + cases);
			
			
			
		}
		
		
	}

}
