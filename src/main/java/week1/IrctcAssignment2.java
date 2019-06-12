package week1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class IrctcAssignment2 {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver irctc = new ChromeDriver();
		irctc.manage().window().maximize();
		irctc.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		irctc.findElementById("userRegistrationForm:userName").sendKeys("testname");
		irctc.findElementById("userRegistrationForm:password").sendKeys("test1");
		irctc.findElementById("userRegistrationForm:confpasword").sendKeys("test1");
		//Create an object for Select the Security Question
		Select sec = new Select(irctc.findElementById("userRegistrationForm:securityQ"));
		List<WebElement> ops = sec.getOptions();
		int count = ops.size();
		sec.selectByIndex(count-1);
		irctc.findElementById("userRegistrationForm:securityAnswer").sendKeys("Chennai");
		irctc.findElementById("userRegistrationForm:firstName").sendKeys("Test FN");
		irctc.findElementById("userRegistrationForm:middleName").sendKeys("Test MN");
		irctc.findElementById("userRegistrationForm:lastName").sendKeys("Test LN");
		irctc.findElementById("userRegistrationForm:gender:0").click();
		irctc.findElementById("userRegistrationForm:maritalStatus:1").click();
		new Select(irctc.findElementById("userRegistrationForm:dobDay")).selectByValue("25");;
		new Select(irctc.findElementById("userRegistrationForm:dobMonth")).selectByVisibleText("AUG");
		new Select(irctc.findElementById("userRegistrationForm:dateOfBirth")).selectByVisibleText("1989");
		Select Occ = new Select(irctc.findElementById("userRegistrationForm:occupation"));
		Occ.selectByIndex(4);
		irctc.findElementById("userRegistrationForm:uidno").sendKeys("ABCDE1233");
		irctc.findElementById("userRegistrationForm:idno").sendKeys("123ABC");
		Select country = new Select(irctc.findElementById("userRegistrationForm:countries"));
		country.selectByValue("94");;
		irctc.findElementById("userRegistrationForm:email").sendKeys("test@test.com");
		irctc.findElementById("userRegistrationForm:mobile").sendKeys("3456789722");
		Select nat = new Select(irctc.findElementById("userRegistrationForm:nationalityId"));
		nat.selectByValue("94");
		irctc.findElementById("userRegistrationForm:address").sendKeys("Address 1");
		irctc.findElementById("userRegistrationForm:street").sendKeys("Street 1");
		irctc.findElementById("userRegistrationForm:area").sendKeys("Area 1");
		irctc.findElementById("userRegistrationForm:pincode").sendKeys("400090");
		irctc.findElementById("userRegistrationForm:statesName").click();
		irctc.findElementById("userRegistrationForm:landline").sendKeys("2345678923");
		new Select(irctc.findElementById("userRegistrationForm:cityName")).selectByIndex(1);
		Thread.sleep(2000);
		new Select(irctc.findElementById("userRegistrationForm:postofficeName")).selectByIndex(1);
		
	}

}
