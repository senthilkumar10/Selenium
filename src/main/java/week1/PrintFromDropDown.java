package week1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PrintFromDropDown {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/ChromeDriver.exe");
	ChromeDriver dropdown = new ChromeDriver();
	dropdown.manage().window().maximize();
	dropdown.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
	
	Select fromDD = new Select(dropdown.findElementById("userRegistrationForm:countries"));
	List<WebElement> ops = fromDD.getOptions();
	
	for(WebElement country:ops)
	{
		System.out.println(country.getText());
	}
	
	
	
	

	}

}
