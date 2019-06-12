package week2;

import org.junit.Test;

import wdMethods.SeMethods;

public class MergeLead_Se extends SeMethods {
	
	@Test
	
	public void MergeLead() throws Exception{
		
		startApp("chrome","http://leaftaps.com/opentaps/control/main");
		type(locateElement("id", "username"), "DemoSalesManager");
		type(locateElement("id", "password"), "crmsfa");
		click(locateElement("class", "decorativeSubmit"));	
		click(locateElement("linktext","CRM/SFA"));
		click(locateElement("linktext","Leads"));
		click(locateElement("linktext","Merge Leads"));
		click(locateElement("xpath","//img[@alt='Lookup']"));
		switchToWindow(1);
		//type(locateElement("xpath", "//input[@class=' x-form-text x-form-field']"), "10441");
		//click(locateElement("class","x-btn-text"));
		Thread.sleep(3000);
		String value = getText(locateElement("xpath","//a[@class='linktext']"));
		clickWithNoSnap(locateElement("xpath","//a[@class='linktext']"));
		switchToWindow(0);
		click(locateElement("xpath","(//img[@alt='Lookup'])[2]"));
		switchToWindow(1);
		//type(locateElement("xpath", "//input[@class=' x-form-text x-form-field']"), "10442");
		//click(locateElement("class","x-btn-text"));
		Thread.sleep(3000);
		clickWithNoSnap(locateElement("xpath","(//a[@class='linktext'])[7]"));
		switchToWindow(0);
		clickWithNoSnap(locateElement("class","buttonDangerous"));
		acceptAlert();
		click(locateElement("linktext","Find Leads"));
		Thread.sleep(2000);
		type(locateElement("xpath", "(//div[@class='x-form-element']/input)[13]"), value);
		click(locateElement("xpath","(//button[@class='x-btn-text'])[7]"));
		verifyExactText(locateElement("xpath","//div[@class='x-toolbar x-small-editor']/div"),"No records to display");
		
		
		
	}

}
