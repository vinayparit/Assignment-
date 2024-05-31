package assignment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlipKartTest
{
	Random ran=new Random();
	int randomNum = ran.nextInt(100);

	@Test
	public void flipkart() throws IOException 
	{

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@placeholder=\"Search for Products, Brands and More\"]"))
				.sendKeys("iphone");
		driver.findElement(By.xpath("//button[@aria-label=\"Search for Products, Brands and More\"]")).click();
		List<WebElement> price = driver.findElements(By.xpath("//div[@class=\"_30jeq3 _1_WHN1\"]"));
		List<WebElement> mobiles = driver.findElements(By.xpath("//div[@class=\"_4rR01T\"]"));
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\AssignmentData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet("Iphone" +randomNum);
		for (int i = 0; i < mobiles.size(); i++) 
		{
			Row row = sh.createRow(i);

			for (int j = 0; j < 1; j++) 
			{
				row.createCell(j).setCellValue(mobiles.get(i).getText());
				row.createCell(j+1).setCellValue(price.get(i).getText());
			}
		}
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\AssignmentData.xlsx");
		wb.write(fos);
		wb.close();
		
	}
}
