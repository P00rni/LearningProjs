package org.maven1_projLearnings;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CSSselector_dropdown_nthoftype {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriver driver = new ChromeDriver();
driver.navigate().to("https://www.waitrose.com/");
driver.manage().window().maximize();


WebElement accept = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/section/div[2]/button[1]"));

WebDriverWait wait = new WebDriverWait(driver, 20);
wait.until(ExpectedConditions.visibilityOf(accept));
accept.click();

Thread.sleep(5000);
WebElement search = driver.findElement(By.cssSelector("#searchTerm"));
search.sendKeys("tomatoes");

search.sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));

Thread.sleep(5000);
driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/section[1]/div/article[3]/div/button")).click();
//Select drop = new Select (driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/section[1]/div/article[3]/div/button")));

Thread.sleep(3000);
//wait.until(ExpectedConditions.visibilityOf(drop));
//drop.selectByIndex(2);

//List<WebElement> li = driver.findElements(By.xpath("//li[@class='option___3paEq' and name='DIETARY_AND_LIFESTYLE']"));

//System.out.print(driver.findElements(By.cssSelector("li[class=option___3paEq]:nth-of-type(2)")).get(3));

List<WebElement> li = driver.findElements(By.cssSelector("li[class=option___3paEq]"));

int i = li.size();

System.out.print(i);

for (int j=0; j<i;j++)
	
{
	System.out.println(li.get(j).getText());

	
}
li.get(1).click();

	}

	
}
