package wdMethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class SeMethods implements WdMethods {
	public RemoteWebDriver driver=null;
	int snapCounter=1;


	public void startApp(String browser, String url) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver_64bit.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (NullPointerException e) {
			System.err.println("The browser does not exists");
			throw new RuntimeException();
		}finally{
			takeSnap();
		}
		

	}

	public WebElement locateElement(String locator, String locValue) {
		WebElement ele =null;
		try {
			switch (locator) {
			case "id":
				ele = driver.findElementById(locValue);			
				break;
			case "class":
				ele =driver.findElementByClassName(locValue);
				break;	
			case "linktext":
				ele=driver.findElementByLinkText(locValue);
				break;
			case "partiallinktext":
				ele=driver.findElementByPartialLinkText(locValue);
				break;
			case "xpath":
				ele=driver.findElementByXPath(locValue);
				break;
			case "name":
				ele=driver.findElementByName(locValue);
				break;
			}
		} catch (NoSuchElementException e) {
			System.err.println("Please verify the locator value");
			throw new RuntimeException();
		}
		return ele;	
	}

	public WebElement locateElement(String locValue) {
		WebElement ele;
		try {
			ele = driver.findElementById(locValue);
		} catch (NoSuchElementException e) {
			System.err.println("Please verify the id value");
			throw new RuntimeException();
		}
		return ele;
	}

	public void type(WebElement ele, String data) {
		try {
			ele.sendKeys(data);
		} catch (WebDriverException e) {
			System.err.println("Unable to enter the data");
			throw new RuntimeException();
		}finally{
			takeSnap();
		}
	}

	public void click(WebElement ele) {
		try {
			ele.click();
		} catch (WebDriverException e) {
			System.err.println("Unable to Click");
			throw new RuntimeException();
		}finally{
			takeSnap();
		}
	}

	public void clickWithNoSnap(WebElement ele) {
		try {
			ele.click();
		} catch (WebDriverException e) {
			System.err.println("Unable to Click");
			throw new RuntimeException();
		}
	}

	public void clear(WebElement ele) {
		try {
			ele.clear();
		} catch (WebDriverException e) {
			System.err.println("Unable to clear");
			throw new RuntimeException();
		}
	}


	public String getText(WebElement ele) {
		String txt=null;
		try {
			 txt = ele.getText();
		
		} catch (WebDriverException e) {
			System.err.println("Unable to Get Text");
			throw new RuntimeException();
		}
		return txt;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			Select dropdown = new Select(ele);
			dropdown.selectByVisibleText(value);
		} catch (WebDriverException e) {
			System.err.println("Unable to Select hence verify the Visible text given");
			throw new RuntimeException();
		}

	}

	public void selectDropDownUsingValue(WebElement ele, String value) {
		try {
			Select dropdown = new Select(ele);
			dropdown.selectByValue(value);
		} catch (WebDriverException e) {
			System.err.println("Unable to Select hence verify the value given");
			throw new RuntimeException();
		}

	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			Select dropdown = new Select(ele);
			dropdown.selectByIndex(index);
		} catch (WebDriverException e) {
			System.err.println("Unable to Select hence verify the index given");
			throw new RuntimeException();
		}

	}

	public boolean verifyTitle(String expectedTitle) {
		boolean ans;
		try {
			if(driver.getCurrentUrl().equalsIgnoreCase(expectedTitle))
				ans=true;
			else
				ans=false;
		} catch (WebDriverException e) {
			System.err.println("Ensure there is a title for this webpage to verify");
			throw new RuntimeException();
		}
		return ans;
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			if(ele.getText().equalsIgnoreCase(expectedText))
				System.out.println("The String "+ expectedText +" is matching exactly");
			else
				System.out.println("The String "+ expectedText +" is not matching exactly");
		} catch (WebDriverException e) {
			System.err.println("Unable to get text");
			throw new RuntimeException();
		}
	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			if(ele.getText().contains(expectedText))
				System.out.println("The given string contains in the input text ");
			else
				System.out.println("The given string does contains in the input text ");
		} catch (WebDriverException e) {
			System.err.println("Unable to get text");
			throw new RuntimeException();
		}


	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			if(ele.getAttribute(attribute).equalsIgnoreCase(value))
				System.out.println("The attribute value is matching");
			else
				System.out.println("The attribute value is not matching");
		} catch (WebDriverException e) {
			System.err.println("Unable to get attribute value");
			throw new RuntimeException();
		}


	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {

		try {
			if(ele.getAttribute(attribute).contains(value))
				System.out.println("The attribute value is contains in the given text");
			else
				System.out.println("The attribute value is not contains in the given text");
		} catch (WebDriverException e) {
			System.err.println("Unable to get attribute value");
			throw new RuntimeException();
		}


	}

	public void verifySelected(WebElement ele) {
		try {
			if(ele.isSelected()==true)
				System.out.println("The WebElement is selected");
			else
				System.out.println("The WebElement is not selected");
		} catch (WebDriverException e) {
			System.err.println("Unable to verify the webelement");
			throw new RuntimeException();
		}

	}

	public void verifyDisplayed(WebElement ele) {
		try {
			if(ele.isDisplayed()==true)
				System.out.println("The webelement is displayed");
			else
				System.out.println("The webelement is not displayed");
		} catch (WebDriverException e) {
			System.err.println("Unable to verify the webelement");
			throw new RuntimeException();
		}

	}

	public void switchToWindow(int index) {
		try {
			Set<String> allwindows = driver.getWindowHandles();
			List<String> alllist = new ArrayList<String>();
			alllist.addAll(allwindows);
			String win = alllist.get(index);
			driver.switchTo().window(win);
		} catch (NoSuchWindowException e) {
			System.err.println("There is no window to switch");
			throw new RuntimeException();
		}
	}



	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
		} catch (NoSuchFrameException e) {
			System.err.println("There is no frame to switch");
			throw new RuntimeException();
		}

	}

	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			System.err.println("There is no alert to accept");
			throw new RuntimeException();
		}

	}

	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			System.err.println("There is no alert to dismiss");
			throw new RuntimeException();
		}

	}

	public String getAlertText() {
		String txt = null;
		try {
			 txt = driver.switchTo().alert().getText();
		} catch (NoAlertPresentException e) {
			System.err.println("There is no alert to get text");
			throw new RuntimeException();		}
		return txt;
	}

	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./snap/snap"+snapCounter+".JPEG");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			System.err.println("Unable to take Snapshot");
			throw new RuntimeException();	
		}

		snapCounter++;
	}

	public void closeBrowser() {
		try {
			driver.close();
		} catch (WebDriverException e) {
			System.err.println("Unable to close the browser");
			throw new RuntimeException();
		}

	}

	public void closeAllBrowsers() {

		try {
			driver.quit();
		}catch (WebDriverException e) {
			System.err.println("Unable to close all the browsers");
			throw new RuntimeException();
			}

	}



}
