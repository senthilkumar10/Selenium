package week1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./drivers/ChromeDriver.exe");
		ChromeDriver selectDD = new ChromeDriver();
		selectDD.manage().window().maximize();
		selectDD.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		Select DD = new Select(selectDD.findElementById("userRegistrationForm:countries"));
		List<WebElement> ops = DD.getOptions();
		int count=0;
		String option;
		for(WebElement test:ops)
		{
			option = test.getText();
			if(test.getText().startsWith("E"))
			{
				count++;
				if(count==2)
				{
					DD.selectByVisibleText(option);
					break;
				}
			}
		}






	}

}
