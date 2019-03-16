package in.lnt.day2;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import util.BrowserSetup;

public class Cpsat {
	

	public static void main(String[] args) {
		WebDriver driver=BrowserSetup.browserStart("firefox","https://www.nseindia.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	     driver.findElement(By.id("keyword")).sendKeys("Reliance Industries Limited");
	   //  Actions action=new Actions(driver);
	     driver.findElement(By.id("keyword")).sendKeys(Keys.ENTER);
	    // driver.findElement(By.xpath("//*[@id=\"ajax_response\"]/ol/li/a")).click();
	     String F =driver.findElement(By.xpath("//*[@id=\"high52\"]/font")).getText();
	     System.out.println("face valu:"+F);
	     TakesScreenshot screen=(TakesScreenshot)driver;
			File src=screen.getScreenshotAs(OutputType.FILE);
			
			try {
				FileHandler.copy(src, new File(".\\DragNdrop44.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error while taking screenshot");
			}
			
		}
	   //String F =driver.findElement(By.xpath("//*[@id=\"high52\"]/font")).getText();

	}


