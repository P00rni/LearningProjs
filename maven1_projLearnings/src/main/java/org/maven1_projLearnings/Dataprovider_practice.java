package org.maven1_projLearnings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Dataprovider_practice {

	WebDriver Driver;

	@BeforeMethod
	@Parameters({ "site", "browser" })

	public void openbrowser(String site, String browser) throws InterruptedException {

		// getting browser value from xml
		switch (browser) {
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

		// loading site by getting site value from xml

		Driver.get(site);
		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();

		// accept cookies
		WebDriverWait wait = new WebDriverWait(Driver, 20);

		WebElement accept = Driver.findElement(By.xpath("/html/body/div[3]/div/div/div/section/div[2]/button[1]"));

		wait.until(ExpectedConditions.visibilityOf(accept));
		accept.click();
		Thread.sleep(5000);

		//Click on signin option
		
		Driver.findElement(By.cssSelector(".signIn___36VsE]")).click();

		// a[class=signIn___36VsE]
	}

	

}
