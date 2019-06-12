package week8;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

public class UploadUsingChrome  {
	@Test
	public void sma() throws InterruptedException, MalformedURLException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://smacar.com/studio"); 
		driver.findElementById("lmail").sendKeys("test007@gmail.com");
		driver.findElementById("lpwd").sendKeys("leaf@123");
		driver.findElementById("login_submit").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//div[text()='NEW CAMPAIGN']").click();
		driver.findElementById("pjtName").sendKeys("trial1",Keys.TAB,Keys.DOWN,Keys.ENTER);
		Thread.sleep(2000);
		driver.findElementByXPath("//a[text()='CREATE']").click();
		driver.findElementByXPath("(//p[@class='text_flow'])[1]").click();

		driver.findElementByXPath("(//div[@class='card small']//div)[1]").click();
		Thread.sleep(3000);	
		String path = "‪C:\\Resume.pdf";
		WebElement ele = driver.findElementByXPath("//input[@type='file']");
		System.out.println(ele);
		LocalFileDetector detect = new LocalFileDetector();
		((RemoteWebElement)ele).setFileDetector(detect);
		ele.sendKeys(detect.getLocalFile(path).getAbsolutePath());
		Thread.sleep(8000);
		driver.findElementByXPath("//*[@id='submit-all']").click();
	}
}
