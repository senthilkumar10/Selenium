package week1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginLeafTab {

	public static void main(String[] args) {
	
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
				
		// maximize the browser
		
		driver.manage().window().maximize();
		
		//Load the URL
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//Locate the element and enter the username
		
		driver.findElementById("username").sendKeys("DemoSalesManager");
		
		//Locate the element and enter the Password
		
		driver.findElementById("password").sendKeys("crmsfa");
		
		//Locate the login button and click
		
		driver.findElementByClassName("decorativeSubmit").click();
				
		//Locate the link and click
		
		driver.findElementByLinkText("CRM/SFA").click();
		
		//Locate the Create Lead link and click
		
		driver.findElementByLinkText("Create Lead").click();
		
		//Enter the company Name, First Name and Last Name
		
		driver.findElementById("createLeadForm_companyName").sendKeys("Test Leaf");
		
		driver.findElementById("createLeadForm_firstName").sendKeys("Senthil");
				
		driver.findElementById("createLeadForm_lastName").sendKeys("Kumar");
		
		//Code to select a value from the drop down.
		
		//Store the value from id and store in Sec1
		
		WebElement Sec1 = driver.findElementById("createLeadForm_dataSourceId");
		
		Select dd = new Select(Sec1);
		
		dd.selectByValue("LEAD_EMPLOYEE");
		
		// To get all the options 
		
		Select dd1 = new Select(driver.findElementById("createLeadForm_marketingCampaignId"));
		
		List<WebElement> allOptions = dd1.getOptions();
		
		int count = allOptions.size();
		
		dd1.selectByIndex(count-2);
		
		//Submit the value and create Lead
		
		//driver.findElementByClassName("smallSubmit").click();
		
		//Click on Find Leads Link
		
		/*driver.findElementByLinkText("Find Leads").click();
		
		//Click on Phone Tab
		
		driver.findElementByXPath("(//a[@class='x-tab-right'])[2]").click();
		
		//Enter the Phone Number
		driver.findElementByXPath("//input[@name='phoneCountryCode']").clear();
		driver.findElementByXPath("//input[@name='phoneCountryCode']").sendKeys("91");
		driver.findElementByXPath("//input[@name='phoneAreaCode']").sendKeys("44");
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("987654321");

		//Click Find Leads
		
		driver.findElementByXPath("(//td[@class='x-btn-center'])[7]").click();
		
		//Close the browser
		
		//driver.quit();
		
*/		
		
		//Locate the logout button and click
		
//		driver.findElementByClassName("decorativeSubmit").click();
		
		

	}

}
