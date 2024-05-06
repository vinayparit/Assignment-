package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManualBrowser {
	

//	chrome.exe --remote-debugging-port=9222 --user-data-dir="<Folder-path>"
//	chrome.exe --remote-debugging-port=6342 --user-data-dir="E:\Test"
	
	public static void main(String[] args) 
	
	{
		
		WebDriverManager.chromedriver().setup();
//		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application");
		ChromeOptions options= new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", "localhost:5252");
//		options.setExperimentalOption("", options)
		WebDriver driver=new ChromeDriver(options);
//		driver.get("https://www.facebook.com");
//		driver.findElement(By.cssSelector("[data-testid=\"open-registration-form-button\"]"));
		driver.close();
	}
}
