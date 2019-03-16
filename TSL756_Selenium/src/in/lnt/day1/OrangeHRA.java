package in.lnt.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OrangeHRA {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Jars\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login/");
		driver.findElement(By.cssSelector("input[name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.cssSelector("input[name='Submit']")).click();
		driver.findElement(By.linkText("Welcome Admin")).click();
		//Thread.sleep(3000);//to hold for the page for a while to match the speed between 
		//Selenium and application under test
		driver.findElement(By.linkText("Logout")).click();;
		
	}

}
