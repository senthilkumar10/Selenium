package week8;

import java.io.IOException;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDemo {

	public static void main(String[] args) throws WebDriverException, IOException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeOptions ch = new ChromeOptions();
		
				// Headless mode
		//ch.setHeadless(true);
		
		//To run in private mode
		ch.addArguments("-incognito");
		
		//To disable automation browser running infobar
		ch.addArguments("disable-infobars");
		
		//To maximize the browser
		//ch.addArguments("start-maximized");
		
		//To run the browser in full screen
		ch.addArguments("--start-fullscreen");
		ChromeDriver driver = new ChromeDriver(ch);

		driver.get("http://www.naukri.com");
		System.out.println(driver.getTitle());		
	 
	}

}
