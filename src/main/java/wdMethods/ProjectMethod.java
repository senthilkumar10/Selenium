package wdMethods;

import org.testng.annotations.*;

public class ProjectMethod extends SeMethods {

	@BeforeMethod(groups="common")
	@Parameters({"url","uname","pwd"})
	public void loginTestLeaf(String uRL,String userName, String password)
	{
		startApp("chrome",uRL);
		type(locateElement("id", "username"), userName);
		type(locateElement("id", "password"), password);
		click(locateElement("class", "decorativeSubmit"));	
		click(locateElement("linktext","CRM/SFA"));
	}
	
	@AfterMethod(groups="common")
	public void close()
	{
		closeBrowser();
	}
	
	
	
}
