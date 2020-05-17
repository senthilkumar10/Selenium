package seleniumpractise;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WordCountInWeb {

	public static void main(String[] args)  {

		//System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		WebDriver driver;

		
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();

		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.google.co.in/");

		driver.quit();
	
		//driver.findElement(By.xpath("//input[contains(@class,'gsfi')]")).sendKeys("cricket");
		//driver.findElement(By.xpath("//input[contains(@class,'gsfi')]")).sendKeys(Keys.TAB);
		
		//driver.findElement(By.name("btnK")).click();
		
		//ArrayList<String> ps = new ArrayList<String>();
	//	ps = driver.getPageSource();
		
		
		//String arg = "return arguments[0].innerHTML";
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//String pageSource = (String) js.executeScript(arg, driver.findElementByTagName("html"));
		//String pageSource = (String) js.executeScript("document.querySelector('html').outerHTML");
		
		//System.out.println(pageSource);
		
		/*
		
		String ps = driver.getPageSource();
		System.out.println(ps);
		String psword[] = ps.split(" ");
		int beforeLen = psword.length;
		System.out.println("Number words in the page with the String = "+beforeLen);
		String psRemoveCric = ps.replace("cricket", "");
		String psWordCount[] = psRemoveCric.split(" ");
		int afterLen = psWordCount.length;
		System.out.println("Number words in the page without the String = "+afterLen);*/
		
		
		


	}

}
