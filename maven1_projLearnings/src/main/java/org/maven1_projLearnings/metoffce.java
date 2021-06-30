package org.maven1_projLearnings;
/** 
 * Author: Poornima
 * Date: 28.04.2021
 * last update:
 * tc id:
 * scr id: 
 * Task: COmpare temp of same time on two days and display which day is hottest
 * TestNG PRoj 1
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class metoffce {

	public WebDriver Driver;// = new ChromeDriver();
	//public String url = "https://www.metoffice.gov.uk/";
	public String a, b;

	@BeforeTest
	@Parameters({"site2" , "browser"})
	public void openbrowser(String site2, String browser) throws InterruptedException {

		
		switch(browser)
		{
		case "chrome":
		
			Driver = new ChromeDriver();
			break;
		
		case "firefox":
			
			Driver = new FirefoxDriver();
			break;
			
		case "IE":
			Driver = new InternetExplorerDriver();
			break;
			
		}
		Driver.get(site2);

		Driver.manage().window().maximize();

		Thread.sleep(1000);

	}
		
//public static void main(String[] args) throws InterruptedException {
	// TODO Auto-generated method stub

	@Test(priority = 0)
	public void OpenWebPage() throws InterruptedException {


		// wait until the cookie frame appears and accept all

		WebDriverWait wait = new WebDriverWait(Driver, 10);

		WebElement element = Driver.findElement(By.xpath("//*[@id=\"ccc-recommended-settings\"]"));

		wait.until(ExpectedConditions.visibilityOf(element));

		element.click();
		
		Thread.sleep(10000);
	}

	@Test(priority = 1)
	@Parameters({"location"})
	public void FindLocation(String location) {

		// Enter location in search bar

		WebElement search = Driver.findElement(By.id("location-search-input"));

		search.sendKeys("location");

		search.submit();
	}
	// select the first option on search result

	/*
	 * List<WebElement> links = Driver.findElements(new ByAll(By.tagName("a"),
	 * By.className("location-results-box")) );
	 * 
	 * //System.out.println(links);
	 * 
	 * for (WebElement webElement : links) { String name = webElement.getText();
	 * System.out.println(name);}
	 */

	// selecting location from available results

	@Test(priority = 2)
	public void GetTemp() throws InterruptedException {
		Driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/ul/li[1]/a"))
				.click();
		
		Driver.findElement(By.xpath("//*[@id='tabDay2']")).click();

		 a = Driver.findElement(By.xpath("//*[@id=\"2021-04-30\"]/table/tbody/tr[5]/td[5]"))
				.getAttribute("data-temp");
		 Thread.sleep(5000);

		Driver.findElement(By.xpath("//*[@id=\"dayLink2021-05-01\"]")).click();

		 b = Driver.findElement(By.xpath("//*[@id=\"2021-05-01\"]/table/tbody/tr[5]/td[5]"))
				.getAttribute("data-temp");
		 System.out.println("Friday Weather at 9.00a.m. is :" + a + "Sunday Weather at 9.00a.m. is:" + b);

	}
		 
			@Test(priority = 3)
			public void Compare() {
		float f = Float.parseFloat(a);
		float g = Float.parseFloat(b);

		
		if (f > g)

		{
			System.out.println("Friday is hotter");
		} else {
			System.out.println("Sunday is hotter");
		}
	}
	
	@AfterTest
	
	public void CloseDriver() {
		
		Driver.close();
	}


}
