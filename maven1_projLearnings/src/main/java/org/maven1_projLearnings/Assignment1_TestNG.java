package org.maven1_projLearnings;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Assignment1_TestNG {

	//public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

	//public WebDriver Driver = new ChromeDriver();
	
	WebDriver Driver;
	public String id = "mrsbala.poo@gmail.com";
		public String pwd = "ABC123456";
		public String clickenter = Keys.chord(Keys.CONTROL, Keys.ENTER);
		
		
	@BeforeTest
	@Parameters({"site","browser"})
	public void openbrowser(String site, String browser) throws InterruptedException
	{
		
		//Getting browser value from xml
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
		
		//loading site with value from xml
		
		Driver.get(site);
		Driver.manage().window().maximize();
		
		//accepting cookies
		WebDriverWait wait = new WebDriverWait(Driver, 20);
		
		WebElement accept = Driver.findElement(By.xpath("/html/body/div[3]/div/div/div/section/div[2]/button[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(accept));
		accept.click();
		Thread.sleep(5000);
		
		
	}
	
	
		//searching item in search bar	
	@Test (priority =1 , alwaysRun = true)
	@Parameters({"item"})
	
	public void searchitem(String item) throws InterruptedException
	{
		
	WebElement search = Driver.findElement(By.xpath("//*[@id=\"searchTerm\"]"));
	
	search.clear();
	search.sendKeys(item);
	
	
	
	search.sendKeys(clickenter);
	
	Thread.sleep(2000);
	
	Driver.findElement(By.xpath("//article[@id='tPp745533-162203-162204']/div[1]/section[1]/header[@class='podHeader___3yaub' and 1]")).click();
	
	//Driver.findElement(By.xpath("//*[contains(@data-product-name , Cirio Polpa Chopped Tomatoes) and (@data-product-on-offer, true)]  ")).click();
	
	//*[@id="tPp086535-44218-44219"]
	
	Driver.findElement(By.id("tAbtn-745533-162203-162204")).click();
	
	String title1=Driver.getTitle();
	
	System.out.println(title1);
	
	if(title1.contains("Log in"))
		
	{System.out.println("please Login to proceed shopping");}
	
	
	}
	
	
@Test (priority =2 , alwaysRun = false, dependsOnMethods = {"searchitem"})
	
	public void login() throws InterruptedException
	{
	
	Driver.findElement(By.name("email")).sendKeys(id);
	Driver.findElement(By.name("password")).sendKeys(pwd);
Driver.findElement(By.id("loginSubmit")).click();
	
	Thread.sleep(5000);
/*if (Driver.findElement(By.id("account-details")).isDisplayed())
	{System.out.println("login successful");} else
	{System.out.println("login unsuccessful");}*/
	
	}


@Test (priority =3,dependsOnMethods = {"login"} )

public void checkout()
{
	System.out.println(Driver.getWindowHandles());
	
	
			
		//	WebElement b = Driver.findElement(By.xpath("/html/body/div[7]/div"));
		//	b.click();
			
		//	String a = b.getText();
//	System.out.println(a);
	
	// ArrayList<String> tabs = new ArrayList<String> (Driver.getWindowHandles());
	
//	Driver.switchTo().window(tabs.get(0));
	
//	Driver.switchTo().frame(1);
	
	/*Alert a = Driver.switchTo().alert();
	
	System.out.println(a.getText());
	
	a.accept();*/
	Driver.findElement(By.xpath("/html/body/div[15]/div")).click();
	
	Driver.findElement(By.xpath("/html/body/div[15]/div/div/div/section/ul/li[1]/button")).click();
	//Driver.findElement(By.id("trolleyOverview")).click();
	
}
	
}
