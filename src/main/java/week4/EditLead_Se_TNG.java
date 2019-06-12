package week4;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import wdMethods.ProjectMethod;
public class EditLead_Se_TNG extends ProjectMethod
{
	//dependsOnMethods="week4.CreateLead_Se_TNG.createLeadTC"
	@Test(groups = "smoke",dataProvider="fetchedit")
public void EditLeadsProject(String fn,String cn) throws Exception
{
		click(locateElement("linktext","Leads"));
		click(locateElement("xpath","//a[text()='Find Leads']"));
		type(locateElement("xpath","(//input[@name='firstName'])[3]"),fn);
		click(locateElement("xpath","//button[text()='Find Leads']"));
		Thread.sleep(2000);
		click(locateElement("xpath","//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		verifyTitle("View Lead | opentaps CRM");
		click(locateElement("xpath","//a[text()='Edit']"));
		clear(locateElement("xpath","(//input[@name='companyName'])[2]"));
		type(locateElement("xpath","(//input[@name='companyName'])[2]"),cn);
		click(locateElement("xpath","(//input[@class='smallSubmit'])"));
		verifyPartialText(locateElement("id","viewLead_companyName_sp"),cn);
		
		
}
	
	@DataProvider(name="fetchedit")
	public String[][] getdata()
	{
		String[][] data = new String[1][2];
		data[0][0] = "test";
		data[0][1] = "syntel";
		return data;
		
		
	}
}
