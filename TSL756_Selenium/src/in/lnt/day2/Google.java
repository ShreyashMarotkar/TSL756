package in.lnt.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import util.BrowserSetup;

public class Google {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		WebDriver driver=BrowserSetup.browserStart("chrome", "http://google.com");
		Actions action= new Actions(driver);
		WebElement search = driver.findElement(By.name("q"));
		
		
		Action a=action.moveToElement(search).keyDown(Keys.SHIFT).sendKeys(search,"lnt").keyUp(Keys.SHIFT).doubleClick(search).contextClick(search).build();
		a.perform();
	}

}
