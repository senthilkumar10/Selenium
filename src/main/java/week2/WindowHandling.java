package week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
	driver.findElementByLinkText("Contact Us").click();
	Set<String> allwindows = driver.getWindowHandles();
	List<String> alllist = new ArrayList<String>();
	alllist.addAll(allwindows);
	String childwindow = alllist.get(1);
	String parentwindow = alllist.get(0);
	driver.switchTo().window(childwindow);
	System.out.println("The Child Window URL is = "+ driver.getCurrentUrl());
	System.out.println("The Child Window Title is = "+ driver.getTitle());
	driver.switchTo().window(parentwindow);
	driver.close();
	
	
	
	
	
	
	
	
	

	}

}
