package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Mmt {

	
	public void date(WebDriver driver, String Month,String Date)
	{
		driver.findElement(By.xpath("//div[.='"+Month+"']/parent::div[@class=\"DayPicker-Month\"]/descendant::p[.='"+Date+"']")).click();
	}
}
