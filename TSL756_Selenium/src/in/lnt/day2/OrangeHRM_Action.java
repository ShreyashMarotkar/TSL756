package in.lnt.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OrangeHRM_Action {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Jars\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions action=new Actions(driver); 
	
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login/");
		driver.findElement(By.cssSelector("input[name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.cssSelector("input[name='Submit']")).click();
		
		action.moveToElement(driver.findElement(By.id("menu_admin_viewAdminModule"))).perform();;
		action.moveToElement(driver.findElement(By.linkText("Organization"))).perform();
		action.click(driver.findElement(By.linkText("General Information"))).perform();
		
		
	}

}
