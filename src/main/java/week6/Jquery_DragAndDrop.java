package week6;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Jquery_DragAndDrop {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/sortable/");
		WebElement frame = driver.findElementByClassName("demo-frame");
		driver.switchTo().frame(frame);
		WebElement item1 = driver.findElementByXPath("//li[@class='ui-state-default ui-sortable-handle']");
		WebElement item4 = driver.findElementByXPath("(//li[@class='ui-state-default ui-sortable-handle'])[4]");
		//Get Y cordinates of Item 1 destination
		int Ycod= item4.getLocation().getY();	
		
		Actions builder = new Actions(driver);
		
		builder.dragAndDropBy(item1, 0, Ycod).click().perform();;
	

	}

}
