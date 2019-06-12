package week8;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.chrome.ChromeDriver;

public class Scroll {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// opening Chrome browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		// maximize the browser
		driver.manage().window().maximize();
		// load the browser with url
		driver.get("https://www.naukri.com/");
		//for BrowserName
		driver.getCapabilities().getBrowserName();
		//driver.findElementByLinkText("Browse All Jobs").click();
		System.out.println(driver.findElementByLinkText("Browse All Jobs").isDisplayed());
	}
}
