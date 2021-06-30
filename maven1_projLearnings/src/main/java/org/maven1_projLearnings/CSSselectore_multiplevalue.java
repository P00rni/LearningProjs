package org.maven1_projLearnings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSselectore_multiplevalue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.yahoo.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector(".phone-no ")).sendKeys("poornima"); // using class name 
		
		
	WebElement signin =	driver.findElement(By.cssSelector("input[id=clogin-signin],[value=Next]"));

	signin.click();
	}

}
