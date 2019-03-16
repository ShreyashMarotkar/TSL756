package in.lnt.day1;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OracleCSS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter your username: ");
		Scanner input = new Scanner(System.in);
		String username = input.nextLine();
		//or
		//String username = scanner.next();
		System.out.println("Enter your password: ");
		String password = input.nextLine();
		System.setProperty("webdriver.chrome.driver","D:\\Jars\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:6113496657052290105::NO:::");
	    driver.findElement(By.cssSelector("input#P11_USERNAME")).sendKeys(username);
	    driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);
	    driver.findElement(By.cssSelector("input[value='Login']")).click();
	   // driver.findElement(By.cssSelector("img[title='Logout']")).click();
	   // driver.findElement(By.cssSelector("a.htmldbInstruct")).click();
	    if(driver.getTitle().equals("Oracle")) {
	    	driver.findElement(By.cssSelector("img[title='Logout']")).click();
	 	   driver.findElement(By.cssSelector("a.htmldbInstruct")).click();
	    	System.out.println("Login Done");
	    }
	    else
	    	System.out.println("failed");
	    driver.quit();
	}

}
	
