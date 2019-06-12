package week6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MouseHover {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");	
		ChromeDriver driver = new ChromeDriver();	
		driver.get("https://www.flipkart.com");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		try {
			driver.findElementByXPath("//button[text()='✕']").click();
		} catch (Exception e) {

		}
		WebElement electronics= driver.findElementByXPath("//span[text()='Electronics']");
		WebElement apple= driver.findElementByXPath("//span[text()='Apple']");
		Actions builder = new Actions(driver);
		builder.moveToElement(electronics).perform();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(apple));
		builder.click(apple).build().perform();

	}

}
