package Day7;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.Base;

public class OracleDelete extends Base {
	
	Cookie C=null;
	@Test
	public void oracleCookie() throws Exception {

		
		driver.get("http://127.0.0.1:8080/htmldb");
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("System");
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Newuser123");
		driver.findElement(By.xpath("//*[@value='Login']")).click();
		
		
		Set<Cookie> allCookies = driver.manage().getCookies();
		for (Cookie C : allCookies) {
			System.out.println("Cookie Name is" + C.getName());
			System.out.println("Cookie Domain is" + C.getDomain());
			System.out.println("Cookie Expiry is" + C.getExpiry());
			System.out.println("Cookie Value is" + C.getValue());
			System.out.println("Cookie Path is" + C.getPath());
		}
		
		
			driver.manage().deleteAllCookies();
			//driver.findElement(By.linkText("SQL")).click();
			driver.navigate().refresh();
			Assert.assertEquals(driver.getTitle(), "HTML DB Login");
			
			Thread.sleep(4000);
	}}
