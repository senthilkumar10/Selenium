package week4;

import org.testng.annotations.Test;

import wdMethods.ProjectMethod;


public class MergeLead_Se_TNG extends ProjectMethod {
	
	@Test(groups = "sanity", dependsOnGroups="smoke")
	
	public void MergeLead() throws Exception{
		
		click(locateElement("linktext","Leads"));
		click(locateElement("linktext","Merge Leads"));
		click(locateElement("xpath","//img[@alt='Lookup']"));
		switchToWindow(1);
		Thread.sleep(3000);
		String value = getText(locateElement("xpath","//a[@class='linktext']"));
		clickWithNoSnap(locateElement("xpath","//a[@class='linktext']"));
		switchToWindow(0);
		click(locateElement("xpath","(//img[@alt='Lookup'])[2]"));
		switchToWindow(1);
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
