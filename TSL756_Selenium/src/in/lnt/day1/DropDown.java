package in.lnt.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Jars\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.blazedemo.com/");
		Select select=new Select(driver.findElement(By.name("fromPort")));
		//select.selectByVisibleText("Portland");
		//or
		//select.selectByIndex(6);
		//or
		select.selectByValue("Boston");
		System.out.println(driver.findElement(By.name("fromPort")).getText());
		List<WebElement> ls= select.getOptions();
		
		 for(int i=0;i<ls.size();i++) {
		System.out.println(ls.get(i).getText());	
		 }
		 
		 new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("Rome");
		 driver.findElement(By.cssSelector("input[value='Find Flights']")).click();
		 //Purchase Flight
		 //driver.findElement(By.cssSelector("input[value='Choose This Flight']")).click();
		List<WebElement> all=driver.findElements(By.cssSelector("input[value='Choose This Flight']"));
		all.get(4).click();
		driver.findElement(By.cssSelector("input[name='inputName']")).sendKeys("aditya");
		driver.findElement(By.cssSelector("input[name='address']")).sendKeys("MIET");
		driver.findElement(By.cssSelector("input[name='city']")).sendKeys("gondia");
		driver.findElement(By.cssSelector("input[name='state']")).sendKeys("Maharashtra");
		driver.findElement(By.cssSelector("input[name='zipCode']")).sendKeys("44161");
		
		new Select(driver.findElement(By.name("cardType"))).selectByVisibleText("Visa");
		
		driver.findElement(By.cssSelector("input[name='creditCardNumber']")).sendKeys("514524115114");
		driver.findElement(By.cssSelector("input[name='creditCardMonth']")).sendKeys("January");
		driver.findElement(By.cssSelector("input[name='creditCardYear']")).sendKeys("2025");
		driver.findElement(By.cssSelector("input[name='nameOnCard']")).sendKeys("aditya");
		driver.findElement(By.cssSelector("input[value='Purchase Flight']")).click();

	}

}
