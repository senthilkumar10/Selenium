package week2;

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameTest {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
	driver.switchTo().frame("iframeResult");
	driver.findElementByXPath("//button[@onclick='myFunction()']").click();
	driver.switchTo().alert().sendKeys("Senthil");
	driver.switchTo().alert().accept();
	String txt = driver.findElementByXPath("((//body[@contenteditable='false'])/p)[2]").getText();
	if (txt.contains("Senthil")==true)
		System.out.println("The Entered text is matching");
	else
		System.out.println("The Entered text is not matching");
	
	driver.switchTo().defaultContent();
		
	
	}

}
