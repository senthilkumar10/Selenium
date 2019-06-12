package week1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://leafground.com/pages/Dropdown.html");
	
	//Select using Index
	Select dropdown1 = new Select(driver.findElementById("dropdown1"));
	List<WebElement> ops = dropdown1.getOptions();
	int count = ops.size();
	dropdown1.selectByIndex(count-2);
	
	//Select using Text
	driver.findElementByName("dropdown2").sendKeys("Loadrunner");
	Select dropdown3 = new Select(driver.findElementById("dropdown3"));
	dropdown3.selectByVisibleText("Selenium");
	
	//Get the number of dropdown options
	
	Select dropdown4 = new Select(driver.findElementByClassName("dropdown"));
	List<WebElement> ops1 = dropdown4.getOptions();
	int count1 = ops1.size();
	System.out.println("The Number of options in the 4th dropdown is = " + count1);
	
	//Select using Sendkeys
	
	driver.findElementByXPath("((//div[@class='example'])/select)[5]").sendKeys("UFT/QTP");
	
	
	//Select a text from the listbox
	
	Select dropdown5 = new Select(driver.findElementByXPath("((//div[@class='example'])/select)[6]"));
	dropdown5.selectByValue("2");
	
	}

}
