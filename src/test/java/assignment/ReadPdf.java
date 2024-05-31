package assignment;

import org.openqa.selenium.chrome.ChromeDriver;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ReadPdf {

	@Test
	public void readPdf() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\Users\\ADMIN\\Downloads\\Framwork (1).pdf");
		URL url = new URL(driver.getCurrentUrl());
		InputStream is = url.openStream();
		BufferedInputStream brt = new BufferedInputStream(is);
		PDDocument document = null;
		String output = null;
		try {
			document = PDDocument.load(brt);
			output = new PDFTextStripper().getText(document);
		} finally {
			if (document != null) {
				document.close();
			}
			brt.close();
			is.close();
		}
		System.out.println(output);
	}

}
