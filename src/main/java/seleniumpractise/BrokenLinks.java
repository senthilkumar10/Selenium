package seleniumpractise;

import Util.LinkUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class BrokenLinks {

    @Test
    public void findBrokenLinks(){

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http:the-internet.herokuapp.com/");

        Map<Integer, List<String>> linksWithStatusCode = driver.findElements(By.xpath("//*[@href]"))
                .stream()
                .map(ele -> ele.getAttribute("href")) //get the values of href
                .map(String::trim)                          // trim the text
                .distinct()                                 //there could be duplicate links , so find unique
                .collect(Collectors.groupingBy(LinkUtil::getResponseCode)); // group the links based on the response code

        System.out.println(linksWithStatusCode.get(200));
        System.out.println(linksWithStatusCode.get(403));
        System.out.println(linksWithStatusCode.get(404));
        System.out.println(linksWithStatusCode.get(0));

        Map<Boolean, List<String>> linksByPartition = driver.findElements(By.xpath("//*[@href]"))
                .stream()
                .map(ele -> ele.getAttribute("href")) //get the values of href
                .map(String::trim)
                .distinct()
                .collect(Collectors.partitioningBy(link -> LinkUtil.getResponseCode(link)==200));

        linksByPartition.get(true)
                .stream()
                .forEach(System.out::println);

        driver.quit();

    }

}
