package in.lnt.day2;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.BrowserSetup;

public class DragNdrop {
public static void main(String[] args) {
	WebDriver driver=BrowserSetup.browserStart("Chrome","http://jqueryui.com/droppable/");
	Actions action=new Actions(driver);
	driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
	WebElement srcElement=driver.findElement(By.id("draggable"));
	WebElement desElement=driver.findElement(By.id("droppable"));
	//WebElement frame=driver.findElement(By.className("demo-frame"));
	action.dragAndDrop(srcElement, desElement).perform();
	//action.dragAndDrop(srcElement, frame).perform();
	BrowserSetup.getScreenShot("abc");

}
}
