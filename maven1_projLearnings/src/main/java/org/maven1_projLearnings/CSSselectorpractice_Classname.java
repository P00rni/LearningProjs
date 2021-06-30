package org.maven1_projLearnings;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSselectorpractice_Classname {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.yahoo.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector(".phone-no ")).sendKeys("poornima"); // using class name 
		
		
	WebElement signin =	driver.findElement(By.cssSelector("input[id=clogin-signin],[value=Next]"));

	signin.click();
	//	driver.findElement(By.cssSelector("#login-signin")).click();
		Thread.sleep(5000);
		try
		{
			WebElement a= driver.findElement(By.cssSelector(".error-msg"));
		
			System.out.print(a.getText());
		
		
		}
		catch(Exception e)
		{
			System.out.print("element not found");
		}
		
		
		
		
		
	}

}
