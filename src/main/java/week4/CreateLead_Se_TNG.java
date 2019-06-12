package week4;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import wdMethods.ProjectMethod;


public class CreateLead_Se_TNG extends ProjectMethod{

	@Test(groups = "smoke",dataProvider="fetchdata")
		
	public void createLeadTC(String cn,String fn, String ln) throws Exception
	{
		
		click(locateElement("linktext","Leads"));
		click(locateElement("linktext","Create Lead"));
		type(locateElement("id", "createLeadForm_companyName"), cn);
		type(locateElement("id", "createLeadForm_firstName"), fn);
		type(locateElement("id", "createLeadForm_firstNameLocal"), "Test_FNL");
		type(locateElement("id", "createLeadForm_personalTitle"), "Mr.");
		type(locateElement("id", "createLeadForm_generalProfTitle"), "Mister");
		type(locateElement("name", "annualRevenue"), "500000");
		type(locateElement("id", "createLeadForm_sicCode"), "250");
		type(locateElement("id", "createLeadForm_description"), "This is for Test");
		type(locateElement("id", "createLeadForm_importantNote"), "This is to document a important note");
		type(locateElement("id", "createLeadForm_lastName"), ln);
		type(locateElement("id", "createLeadForm_lastNameLocal"), "Test LNL");
		type(locateElement("id", "createLeadForm_departmentName"), "Testing Department");
		type(locateElement("id", "createLeadForm_numberEmployees"), "10");
		type(locateElement("id", "createLeadForm_tickerSymbol"), "£$%");
		clear(locateElement("id", "createLeadForm_primaryPhoneCountryCode"));
		type(locateElement("id", "createLeadForm_primaryPhoneCountryCode"), "+91");
		type(locateElement("id", "createLeadForm_primaryPhoneAreaCode"), "44");
		type(locateElement("id", "createLeadForm_primaryPhoneNumber"), "23456789");
		type(locateElement("id", "createLeadForm_primaryPhoneExtension"), "223");
		type(locateElement("id", "createLeadForm_primaryPhoneAskForName"), "Test FNL");
		type(locateElement("id", "createLeadForm_primaryEmail"), "Test@Test.com");
		type(locateElement("id", "createLeadForm_primaryWebUrl"), "www.test.com");
		type(locateElement("id", "createLeadForm_generalToName"), "TestGTN");
		type(locateElement("id", "createLeadForm_generalAttnName"), "General Attnname");
		type(locateElement("id", "createLeadForm_generalAddress1"), "Address Line 1");
		type(locateElement("id", "createLeadForm_generalAddress2"), "Adddres Line 2");
		type(locateElement("id", "createLeadForm_generalCity"), "Chennai");
		type(locateElement("id", "createLeadForm_generalPostalCode"), "500 244");
		type(locateElement("id", "createLeadForm_generalPostalCodeExt"), "23");
		selectDropDownUsingIndex(locateElement("id","createLeadForm_dataSourceId"),2);
		selectDropDownUsingIndex(locateElement("id","createLeadForm_marketingCampaignId"),3);
		selectDropDownUsingIndex(locateElement("id","createLeadForm_industryEnumId"),1);
		selectDropDownUsingIndex(locateElement("id","createLeadForm_ownershipEnumId"),4);
		selectDropDownUsingValue(locateElement("id","createLeadForm_currencyUomId"),"INR");
		selectDropDownUsingText(locateElement("id","createLeadForm_generalCountryGeoId"),"India");
		Thread.sleep(3000);
		selectDropDownUsingValue(locateElement("id","createLeadForm_generalStateProvinceGeoId"),"IN-TN");
		click(locateElement("class","smallSubmit"));
		
	}
	
	@DataProvider(name = "fetchdata")
	public String[][] getdata()
	{
		
		String[][] data = new String[2][3];
		data[0][0] = "Test Leaf";
		data[0][1] = "Test_FN";
		data[0][2] = "Test LN";
		
		data[1][0] = "Test Leaf";
		data[1][1] = "Test_FN1";
		data[1][2] = "Test LN1";		
		
		return data;
	}
	
}
