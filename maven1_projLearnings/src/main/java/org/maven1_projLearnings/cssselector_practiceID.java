package org.maven1_projLearnings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class cssselector_practiceID {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver Driver = new ChromeDriver();
		Driver.navigate().to("https://mail.yahoo.com");
		
		Driver.manage().window().maximize();
		
		//Compare if both syntax are working
		
		/*WebElement create = Driver.findElement(By.cssSelector("a[id=createacc]"));
		
		String a = create.getText();
		
		String b = Driver.findElement(By.cssSelector("#createacc")).getText(); //CSS by id "#"
//System.out.println(a);
	//	Assert.assertTrue(a.equals(b));
		
		if(a.equals(b))
		{
			System.out.print("true");
		}
		else
		{System.out.print("false");} */
		
		
		
		WebElement create = Driver.findElement(By.cssSelector("#createacc"));
		
		Thread.sleep(5000);
		
		
		create.click();
		
		//sending value to FN using class name
		
		Thread.sleep(10000);
		
		WebElement FN = Driver.findElement(By.cssSelector("#usernamereg-firstName"));
		
		
		
		//wait.until(ExpectedConditions.visibilityOf(FN));
		
		FN.sendKeys("Poornima");
		
	}
}
