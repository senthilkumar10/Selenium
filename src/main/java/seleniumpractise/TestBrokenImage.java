package seleniumpractise;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestBrokenImage {
	
	public static WebDriver driver;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Image.html");

		verifyBrokenImages("//img[@src='../images/abcd.jpg']");
		verifyBrokenImages("//img[@src='../images/keyboard.png']");


		driver.quit();
	}


	private static void verifyBrokenImages(String xpath){
		if( driver.findElement(By.xpath(xpath)).getAttribute("naturalWidth").equals("0")){
			System.out.println("Image is broken");
		}else{
			System.out.println("Image is not broken");
		}

	}

}
