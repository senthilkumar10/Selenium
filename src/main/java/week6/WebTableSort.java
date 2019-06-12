package week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableSort {

	public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://erail.in");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElementById("txtStationFrom").clear();
	driver.findElementById("txtStationFrom").sendKeys("MAS",Keys.TAB);
	driver.findElementById("txtStationTo").clear();
	driver.findElementById("txtStationTo").sendKeys("SBC",Keys.TAB);
	driver.findElementByXPath("//label[text() = 'Trains only on date']").click();
	//Before Sorting extract the table content and store it in List
	
	List<String> addTrainNames = new ArrayList<String>();
	List<WebElement> trainNames = driver.findElementsByXPath("//table[@class='DataTable TrainList']//tr/td[2]");
	int len = trainNames.size();
	
	for(int i=0;i<len;i++)
	{
		addTrainNames.add(trainNames.get(i).getText());
	}
	
	Collections.sort(addTrainNames);

	//Add the sorted table content and store it in List
	
	driver.findElementByXPath("//a[@title='Click here to sort on Train Name']").click();
	
	List<String> addTrainNamesSorted = new ArrayList<String>();
	List<WebElement> trainNamesSorted = driver.findElementsByXPath("//table[@class='DataTable TrainList']//tr/td[2]");
	int len1 = trainNamesSorted.size();
	
	for(int i=0;i<len1;i++)
	{
		addTrainNamesSorted.add(trainNamesSorted.get(i).getText());
	}
	
	
	if(addTrainNames.equals(addTrainNamesSorted) == true)
	{
		System.out.println("The sorting is correct");
	}
	else
	{
		System.out.println("The sorting is not correct");
	}
	
	
	}

}
