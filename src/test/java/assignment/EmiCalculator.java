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
	public void emiCalculator() throws InterruptedException {
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
		System.out.println("---Top Bar Data---");
		driver.navigate().refresh();
		List<WebElement> topBarToolTip = driver.findElements(By.cssSelector(
				"[class=\"highcharts-series highcharts-series-0 highcharts-column-series highcharts-tracker\"] [class=\"highcharts-point\"]"));
		for (WebElement ref2 : topBarToolTip) {
			action.moveToElement(ref2).perform();
			List<WebElement> topBarData = driver.findElements(
					By.cssSelector("[class=\"highcharts-label highcharts-tooltip highcharts-color-undefined\"]"));
			for (WebElement data : topBarData) {
				System.out.println(data.getText());
				System.out.println();
			}
		}
		
		System.out.println("---Bot Bar Data---");
		driver.navigate().refresh();
		List<WebElement> botBarToolTip = driver.findElements(By.cssSelector(
				"[class=\"highcharts-series highcharts-series-1 highcharts-column-series highcharts-tracker\"] [class=\"highcharts-point\"]"));
		for (WebElement ref2 : botBarToolTip) {
			action.moveToElement(ref2).perform();
			List<WebElement> topBarData = driver.findElements(
					By.cssSelector("[class=\"highcharts-label highcharts-tooltip highcharts-color-undefined\"]"));
			for (WebElement data : topBarData) {
				System.out.println(data.getText());
				System.out.println();
			}
		}
	}
}
