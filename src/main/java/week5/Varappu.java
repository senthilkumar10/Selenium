package week5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Varappu {

	public static void main(String[] args) throws Exception {
	
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	RemoteWebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://web.whatsapp.com/"); //User has to connect to Whatsapp once the QR code is available
	Thread.sleep(5000);
	driver.findElement(By.id("input-chatlist-search")).sendKeys("Varappu - Organic Foodies");
	driver.findElement(By.xpath("//span[@title='Varappu - Organic Foodies']")).click();
	}

}
