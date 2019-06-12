package week6;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartClick {

	public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.flipkart.com/");
	driver.findElementByXPath("//button[@class='_2AkmmA _29YdH8']").click();
	//driver.findElementByXPath("//span[text()='Electronics']");
	
	Actions builder = new Actions(driver);
	
	builder.moveToElement(driver.findElementByXPath("//span[text()='Electronics']")).perform();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//span[text()='Apple']")));
	builder.click(driver.findElementByXPath("//span[text()='Apple']")).perform();

	}

}
