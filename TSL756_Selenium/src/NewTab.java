import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import util.BrowserSetup;

public class NewTab {
public static void main(String[] args) {
	
	WebDriver driver=BrowserSetup.browserStart("Chrome","https://www.seleniumhq.org/");
	String ParentID=driver.getWindowHandle();
	Actions action=new Actions(driver);
	WebElement search= driver.findElement(By.linkText("Download"));
	action.moveToElement(search).keyDown(Keys.CONTROL).click().perform();
}
}
