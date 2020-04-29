package week1;

import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/checkbox.html");
		boolean a= driver.findElementByXPath("((//div[@class='example'])/input)[6]").isSelected();
		if (a==true)
			System.out.println("The Checkbox is Checked");
		else
			System.out.println("The Checkbox is not Checked");

		driver.quit();

	}

}
