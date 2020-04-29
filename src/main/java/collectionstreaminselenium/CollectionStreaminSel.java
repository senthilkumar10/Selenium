package collectionstreaminselenium;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CollectionStreaminSel {
	
	public static WebDriver driver;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/checkbox.html");
		
		boolean isPresent = returnMatchingString("Selenium");

		if(isPresent) {
			System.out.println("It is Present");
		}else {
			System.out.println("It is not Present");
		}
		System.out.println(isPresent);
		driver.quit();
	}
	
	public static boolean returnMatchingString(String name) {
		List<WebElement> options = driver.findElements(By.className("example"));
		return options.stream().map(x->x.getText().toLowerCase()).anyMatch(x->x.contains(name.toLowerCase()));
	}
}
