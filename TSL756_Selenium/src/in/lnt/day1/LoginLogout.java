package in.lnt.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginLogout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Jars\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:6113496657052290105::NO:::");
	    driver.findElement(By.id("P11_USERNAME")).sendKeys("sys");
	    driver.findElement(By.id("P11_PASSWORD")).sendKeys("Newuser123");
	    //or
	    //driver.findElement(By.name("p_t02")).sendKeys("Newuser123");
	    driver.findElement(By.xpath("/html/body/form/div[6]/table/tbody/tr/td[3]/table[2]/tbody/tr/td/input[1]")).click();
	    driver.findElement(By.linkText("Logout")).click();
	}

}
