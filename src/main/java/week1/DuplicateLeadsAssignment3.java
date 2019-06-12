package week1;

import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLeadsAssignment3 {

	public static void main(String[] args) throws Exception {
	
	System.setProperty("webdriver.chrome.driver", "./drivers/ChromeDriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://leaftaps.com/opentaps/control/main");
	driver.findElementById("username").sendKeys("DemoSalesManager");
	driver.findElementById("password").sendKeys("crmsfa");
	driver.findElementByClassName("decorativeSubmit").click();
	driver.findElementByLinkText("CRM/SFA").click();
	driver.findElementByLinkText("Leads").click();
	driver.findElementByLinkText("Find Leads").click();
	driver.findElementByXPath("(//em[@class='x-tab-left'])[3]").click();
	driver.findElementByName("emailAddress").sendKeys("testabi@gmail.com");
	driver.findElementByXPath("(//td[@class='x-btn-center'])[7]").click();
	Thread.sleep(5000);
	String text = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])/a").getText();
	driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a").click();
	driver.findElementByLinkText("Duplicate Lead").click();
	String title =driver.findElementById("sectionHeaderTitle_leads").getText(); 
	if ( title.equals("Duplicate Lead"))
	{
		System.out.println("The Title is correct");
	}
	driver.findElementByName("submitButton").click();
	
	String text1 = driver.findElementById("viewLead_firstName_sp").getText();
	
	if(text.equals(text1))
		System.out.println("The Test case is passed");
	else
		System.out.println("The Test case is failed");
	
	driver.quit();
	
	
	
	
	

	}

}
