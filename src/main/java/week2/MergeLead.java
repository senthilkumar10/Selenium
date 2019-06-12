package week2;

import java.util.*;

import org.openqa.selenium.chrome.ChromeDriver;

public class MergeLead {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Merge Leads").click();
		driver.findElementByXPath("//img[@alt='Lookup']").click();
		Set<String> allwindows = driver.getWindowHandles();
		List<String> alllist = new ArrayList<String>();
		alllist.addAll(allwindows);
		String parentwindow = alllist.get(0);
		String childwindow = alllist.get(1);
		driver.switchTo().window(childwindow);
		//driver.findElementByXPath("//input[@class=' x-form-text x-form-field']").sendKeys("10481");
		//driver.findElementByClassName("x-btn-text").click();
		Thread.sleep(5000);
		String value = driver.findElementByXPath("//a[@class='linktext']").getText();
		driver.findElementByXPath("//a[@class='linktext']").click();
		driver.switchTo().window(parentwindow);
		driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
		Set<String> allwindows1 = driver.getWindowHandles();
		List<String> alllist1 = new ArrayList<String>();
		alllist1.addAll(allwindows1);
		String parentwindow1 = alllist1.get(0);
		String childwindow1 = alllist1.get(1);
		driver.switchTo().window(childwindow1);
		//driver.findElementByXPath("//input[@class=' x-form-text x-form-field']").sendKeys("10482");
		//driver.findElementByClassName("x-btn-text").click();
		Thread.sleep(5000);
		driver.findElementByXPath("(//a[@class='linktext'])[7]").click();
		driver.switchTo().window(parentwindow1);
		driver.findElementByClassName("buttonDangerous").click();
		driver.switchTo().alert().accept();
		driver.findElementByLinkText("Find Leads").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@class='x-form-element']/input)[13]").sendKeys(value);
		driver.findElementByXPath("(//button[@class='x-btn-text'])[7]").click();
		Thread.sleep(2000);
		String txt = driver.findElementByXPath("//div[@class='x-toolbar x-small-editor']/div").getText();
		System.out.println(txt);
		if(txt.contains("No records to display"))
			System.out.println("The Merge is Successful");
		else
			System.out.println("The Merge is unsuccessful");
		//driver.close();
		
		
		
		
		
		
		
		

	}

}
