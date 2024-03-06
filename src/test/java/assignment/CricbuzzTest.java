package assignment;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//import com.mysql.cj.jdbc.Driver;

public class CricbuzzTest {
	@Test
	public void cricbuzzTest() throws SQLException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.cricbuzz.com/");
		driver.findElement(By.id("live-scores-link")).click();
		driver.findElement(By.xpath(
				"//h1[.='Live Cricket Score']/ancestor::div[@ng-init=\"active_match_type= 'international-tab'\"]/descendant::a[@class=\"text-hvr-underline text-bold\"][1]"))
				.click();
		driver.findElement(By.xpath("//a[.='Scorecard']")).click();
		List<WebElement> runs = driver.findElements(By.xpath("//div[@class=\"cb-col cb-col-100 cb-scrd-itms\"]"));

//				"//div[@class=\"cb-col cb-col-8 text-right text-bold\"]"
//		int i = 0;
		for (WebElement r : runs) {
//			runs.get(i);
			String run = r.getText();
			System.out.println(run);
		}
//		Driver jdbc=new Driver();
//		DriverManager.registerDriver(jdbc);
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet54","root","root");
//		Statement state = con.createStatement();
//		String query="insert into scorecard values(run);";
//		ResultSet result1=state.executeQuery(query);

	}
}
