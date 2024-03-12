package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class EmiCalculator {

	@Test
	public void emiCalculator() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions action = new Actions(driver);

		driver.get("https://emicalculator.net/");
		WebElement values = driver.findElement(By.xpath(
				"//*[name()='g' and @class=\"highcharts-data-labels highcharts-series-0 highcharts-pie-series highcharts-tracker\"]"));
		String valuesOfChart = values.getText();
		System.out.println(valuesOfChart);
		System.out.println("------");

		List<WebElement> toolTip = driver.findElements(By.cssSelector(
				"[class=\"highcharts-markers highcharts-series-2 highcharts-spline-series highcharts-tracker\"] [fill=\"#B8204C\"]"));
		for (WebElement ref1 : toolTip) {
			action.moveToElement(ref1).perform();
			List<WebElement> data = driver.findElements(
					By.cssSelector("[class=\"highcharts-label highcharts-tooltip highcharts-color-undefined\"] "));
			for (WebElement dataRef : data) {
				action.moveToElement(dataRef).perform();
				System.out.println(dataRef.getText());
				System.out.println();

			}
		}
		
		List<WebElement> barToolTip = driver.findElements(By.cssSelector(
				"[class=\"highcharts-series highcharts-series-1 highcharts-column-series highcharts-tracker highcharts-series-hover\"] [class=\"highcharts-point\"]"));
		for (WebElement ref2 : barToolTip) {
			action.moveToElement(ref2).perform();
			List<WebElement> barData = driver.findElements(
					By.cssSelector("[class=\"highcharts-label highcharts-tooltip highcharts-color-undefined\"]"));
			for (WebElement ref3 : barData) {

				System.out.println(ref3.getText());
			}
		}

	}
}
