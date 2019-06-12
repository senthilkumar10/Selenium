package week3;

import org.junit.Test;

import wdMethods.ProjectMethod;
public class EditLead_Se extends ProjectMethod
{
	@Test
public void EditLeadsProject() throws Exception
{
		loginTestLeaf(null, null, null);
		click(locateElement("linktext","Leads"));
		click(locateElement("xpath","//a[text()='Find Leads']"));
		type(locateElement("xpath","(//input[@name='firstName'])[3]"),"test");
		click(locateElement("xpath","//button[text()='Find Leads']"));
		Thread.sleep(2000);
		click(locateElement("xpath","//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		verifyTitle("View Lead | opentaps CRM");
		click(locateElement("xpath","//a[text()='Edit']"));
		clear(locateElement("xpath","(//input[@name='companyName'])[2]"));
		type(locateElement("xpath","(//input[@name='companyName'])[2]"),"syntel");
		click(locateElement("xpath","(//input[@class='smallSubmit'])"));
		verifyPartialText(locateElement("id","viewLead_companyName_sp"),"syntel");
		
		
}
	
	
}
