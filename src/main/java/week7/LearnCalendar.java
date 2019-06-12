package week7;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LearnCalendar {

	public static void main(String[] args) throws ParseException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();

		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();

		//Declare the date that you want to select mm/dd/yyyy
		String dob = "05/22/2025";
		String dobsplit[] = dob.split("/");
		String mon = dobsplit[0].trim();
		String day = dobsplit[1].trim();
		String yer = dobsplit[2].trim();

		driver.findElementById("createLeadForm_birthDate-button").click();

		//This code will extract the current year and month in the calendar
		String txt = driver.findElementByXPath("//td[@class = 'title']").getText();
		String calval[] = txt.split(",");
		String calmon = calval[0].trim();
		String calyear = calval[1].trim();
		
		//This code will select the year as per the given date

		if(Integer.parseInt(yer) < Integer.parseInt(calyear)) {	
			int clicktimes = Integer.parseInt(calyear)-Integer.parseInt(yer);
			for(int i=0;i<clicktimes;i++)
			{
				driver.findElementByXPath("//td[@class = 'button nav']").click();
			}
		}
		else {
			int clicktimes = Integer.parseInt(yer)-Integer.parseInt(calyear);
			for(int i=0;i<clicktimes;i++)
			{
				driver.findElementByXPath("(//td[@class = 'button nav'])[4]").click();
			}

		}

		//Convert the January to 1
		
		Date date = new SimpleDateFormat("MMMM",Locale.ENGLISH).parse(calmon);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int monnum = (cal.get(Calendar.MONTH))+1;
		System.out.println(mon);
		System.out.println(monnum);
		
		//This code will select the month as per the given date

		if(Integer.parseInt(mon) < monnum) {	
			int clicktimes = monnum-Integer.parseInt(mon);
			for(int i=0;i<clicktimes;i++)
			{
				driver.findElementByXPath("(//td[@class = 'button nav'])[2]").click();
			}
		}
		else {
			int clicktimes = Integer.parseInt(mon)-monnum;
			for(int i=0;i<clicktimes;i++)
			{
				driver.findElementByXPath("(//td[@class = 'button nav'])[3]").click();
			}

		}
		
		
		
			
	
		}






	}

	

