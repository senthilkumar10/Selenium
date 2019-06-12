package week2;

import org.junit.Test;

import wdMethods.SeMethods;

public class DuplicateLead_Se extends SeMethods{

	@Test
	
	public void duplicateLead() throws Exception{
	startApp("chrome","http://leaftaps.com/opentaps/control/main");
	type(locateElement("id", "username"), "DemoSalesManager");
	type(locateElement("id", "password"), "crmsfa");
	click(locateElement("class", "decorativeSubmit"));	
	click(locateElement("linktext","CRM/SFA"));
	click(locateElement("linktext","Leads"));
	click(locateElement("linktext","Find Leads"));
	click(locateElement("xpath","(//em[@class='x-tab-left'])[3]"));
	type(locateElement("name", "emailAddress"), "testabi@gmail.com");
	click(locateElement("xpath","(//td[@class='x-btn-center'])[7]"));
	Thread.sleep(5000);
	String text1 = getText(locateElement("xpath","(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])/a"));
	click(locateElement("xpath","//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a"));
	click(locateElement("linktext","Duplicate Lead"));
	verifyExactText(locateElement("id","sectionHeaderTitle_leads"),"Duplicate Lead");
	click(locateElement("name","submitButton"));
	String text2 = getText(locateElement("id","viewLead_firstName_sp"));
	if(text1.equals(text2))
		System.out.println("The Test case is passed");
	else
		System.out.println("The Test case is failed");
	closeBrowser();
		
}
}

