package week3;

import org.junit.Test;

import wdMethods.ProjectMethod;


public class DeleteLead_Se extends ProjectMethod {

	@Test
	public void deleteLead() throws Exception
	{
		loginTestLeaf(null, null, null);
		click(locateElement("linktext","Leads"));
		click(locateElement("xpath","//a[text()='Find Leads']"));
		click(locateElement("xpath","//span[text()='Phone']"));
		type(locateElement("xpath","//input[@name='phoneCountryCode']"),"");
		type(locateElement("xpath","//input[@name='phoneAreaCode']"),"89");
		type(locateElement("xpath","//input[@name='phoneNumber']"),"9677794764");
		click(locateElement("xpath","//button[text()='Find Leads']"));
		Thread.sleep(2000);
		String txt = getText(locateElement("xpath","(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		click(locateElement("xpath","(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		click(locateElement("class","subMenuButtonDangerous"));
		click(locateElement("xpath","//a[text()='Find Leads']"));
		type(locateElement("xpath","//div[@class='x-form-item x-tab-item']//input"),txt);
		Thread.sleep(2000);
		click(locateElement("xpath","(//td[@class='x-btn-center'])[7]"));
		Thread.sleep(2000);
		verifyPartialText(locateElement("xpath","//div[text()='No records to display']"),"No records to display");
		
		
	}
}
