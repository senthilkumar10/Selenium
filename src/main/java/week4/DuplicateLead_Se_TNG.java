package week4;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import wdMethods.ProjectMethod;

public class DuplicateLead_Se_TNG extends ProjectMethod{

	@Test(dataProvider="fetchemail")

	public void duplicateLead(String email) throws Exception{

		click(locateElement("linktext","Leads"));
		click(locateElement("linktext","Find Leads"));
		click(locateElement("xpath","(//em[@class='x-tab-left'])[3]"));
		type(locateElement("name", "emailAddress"), email);
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

	}
	
	@DataProvider(name="fetchemail")
	public String[] getdata()
	{
		String[] data = new String[1];
		data[0] = "testabi@gmail.com";
		return data;
		
		
	}

}

