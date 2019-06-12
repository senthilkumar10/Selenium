package week5;

import java.io.File;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LearnExtentReports {

	@Test
	public void learnReporting()
	{
		ExtentReports report = new ExtentReports("./reports/result.html", false);
		report.loadConfig(new File("./extent_config.xml"));
		ExtentTest test = report.startTest("TC_01_CreateLead", "Create a new Lead TCs");
		
		test.assignCategory("Smoke");
		test.assignAuthor("Karthik");
		
		test.log(LogStatus.PASS, "DemoSales Manager is entered Successfully"+test.addScreenCapture("./../snap/snap1.JPEG"));
		test.log(LogStatus.PASS, "CRMSFA is entered Successfully"+test.addScreenCapture("./../snap/snap1.JPEG"));
		//test.log(LogStatus.FAIL, "Data entered Successfully"+test.addScreenCapture("./../snap/snap1.JPEG"));
		
		report.endTest(test);
		report.flush();
	}

}
