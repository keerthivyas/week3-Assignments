package week3;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Erail {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://erail.in/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//input[@id='chkSelectDateOnly']").click(); //uncheck
		driver.findElementByXPath("//input[@id='chkSelectDateOnly']").click();  //check
		driver.findElementById("txtStationFrom").clear();
		driver.findElementById("txtStationFrom").sendKeys("Mgr Chennai Ctr");
		driver.findElementById("txtStationTo").clear();
		driver.findElementById("txtStationTo").sendKeys("Ksr Bengaluru");
		driver.findElementByXPath("//input[@id=\"buttonFromTo\"]").click();
		Thread.sleep(2000);
		List<WebElement> allElements = driver.findElementsByXPath("//table[@class=\"DataTable TrainList TrainListHeader\"]//tr/td[2]/a");
		int listSize = allElements.size();
		System.out.println("Size of list " + listSize);
		for (WebElement eachElement : allElements) {
			String text = eachElement.getText();
			System.out.println(text);
		}
		Set<String> allElementsSet = new LinkedHashSet<String>();
		for (WebElement eachElement : allElements) {
			String text = eachElement.getText();
			allElementsSet.add(text);
			
		}
		System.out.println("Size of Set " + allElementsSet.size());
		
		if (allElements.size()==allElementsSet.size()) {
			
			System.out.println("Names are Unique - Not contains Duplicates");
			
		} else {

			System.out.println("Contains Duplicates");
		}
		
	}

}
