package week1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LeaftabsAssignment1 {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver drive = new ChromeDriver();
		//Maximize the browser
		drive.manage().window().maximize();
		//Launch the URL
		drive.get("http://leaftaps.com/opentaps/control/main");
		//enter user name
		drive.findElementById("username").sendKeys("DemoSalesManager");
		//enter password
		drive.findElementById("password").sendKeys("crmsfa");
		//Click on Login button
		drive.findElementByClassName("decorativeSubmit").click();
		//Go to CRM/SFA Link
		drive.findElementByLinkText("CRM/SFA").click();
		//Click on Leads Tab
		drive.findElementByLinkText("Leads").click();
		//Click on Create Lead Link
		drive.findElementByLinkText("Create Lead").click();
		//Fill the Form which has text box (a.k.a input tag)
		drive.findElementById("createLeadForm_companyName").sendKeys("Test Leaf");
		drive.findElementById("createLeadForm_firstName").sendKeys("Test_FN");
		drive.findElementById("createLeadForm_firstNameLocal").sendKeys("Test_FNL");
		drive.findElementById("createLeadForm_personalTitle").sendKeys("Mr");
		drive.findElementById("createLeadForm_generalProfTitle").sendKeys("Mister");
		drive.findElementByName("annualRevenue").sendKeys("500000");
		drive.findElementById("createLeadForm_sicCode").sendKeys("250");
		drive.findElementById("createLeadForm_description").sendKeys("This is for Test");
		drive.findElementById("createLeadForm_importantNote").sendKeys("This is to document important Note");
		drive.findElementById("createLeadForm_lastName").sendKeys("TestLN");
		drive.findElementById("createLeadForm_lastNameLocal").sendKeys("TestLNL");
		drive.findElementById("createLeadForm_departmentName").sendKeys("Test Dept");
		drive.findElementById("createLeadForm_numberEmployees").sendKeys("10");
		drive.findElementById("createLeadForm_tickerSymbol").sendKeys("%&%");
		drive.findElementById("createLeadForm_primaryPhoneCountryCode").clear();
		drive.findElementById("createLeadForm_primaryPhoneCountryCode").sendKeys("+91");
		drive.findElementById("createLeadForm_primaryPhoneAreaCode").sendKeys("44");
		drive.findElementById("createLeadForm_primaryPhoneNumber").sendKeys("23456789");
		drive.findElementById("createLeadForm_primaryPhoneExtension").sendKeys("223");
		drive.findElementById("createLeadForm_primaryPhoneAskForName").sendKeys("TestFNL");
		drive.findElementById("createLeadForm_primaryEmail").sendKeys("Test@Test.com");
		drive.findElementById("createLeadForm_primaryWebUrl").sendKeys("www.test.com");
		drive.findElementById("createLeadForm_generalToName").sendKeys("TestFNL");
		drive.findElementById("createLeadForm_generalAttnName").sendKeys("TestFN");
		drive.findElementById("createLeadForm_generalAddress1").sendKeys("Address Line 1");
		drive.findElementById("createLeadForm_generalAddress2").sendKeys("Address Line 2");
		drive.findElementById("createLeadForm_generalCity").sendKeys("Chennai");
		drive.findElementById("createLeadForm_generalPostalCode").sendKeys("500 024");
		drive.findElementById("createLeadForm_generalPostalCodeExt").sendKeys("23");
		
		
		//Fill the form which has drop down (a.k.a Select & Options tag)
		//Create obj for Source dropdown
		Select srcOptions = new Select(drive.findElementById("createLeadForm_dataSourceId"));
		List<WebElement> srcList = srcOptions.getOptions();
		int srcCount = srcList.size();
		srcOptions.selectByIndex(srcCount/2);
		//Create obj for Marketing Campaingn dropdown
		Select mcOptions = new Select(drive.findElementById("createLeadForm_marketingCampaignId"));
		List<WebElement> mcList = mcOptions.getOptions();
		int mcCount = mcList.size();
		mcOptions.selectByIndex(mcCount-2);
		//Create obj for Industry
		Select indOptions = new Select(drive.findElementById("createLeadForm_industryEnumId"));
		List<WebElement> indList = indOptions.getOptions();
		int indCount = indList.size();
		indOptions.selectByIndex(indCount/2);
		//Create obj for Ownership
		Select owOptions = new Select(drive.findElementById("createLeadForm_ownershipEnumId"));
		List<WebElement> owList = owOptions.getOptions();
		int owCount = owList.size();
		owOptions.selectByIndex(owCount/2);
		//Create Obj to select the Currently
		Select pc = new Select(drive.findElementById("createLeadForm_currencyUomId"));
		pc.selectByValue("INR");
		//Create obj to select the country
		Select con = new Select(drive.findElementById("createLeadForm_generalCountryGeoId"));
		con.selectByVisibleText("India");
		//Add Explicit wait so that State dropdown value get loaded once the country is selected
		Thread.sleep(3000);
		//Create obj to Select the State
		Select st = new Select(drive.findElementById("createLeadForm_generalStateProvinceGeoId"));
		st.selectByValue("IN-TN");
		

	}

}
