package in.lnt.day2;

import java.util.Set;
import java.util.*;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.BrowserSetup;

public class TabHandling {
	public static void main(String[] args) {
		
		WebDriver driver=BrowserSetup.browserStart("Chrome","https://www.seleniumhq.org/");
		String ParentID=driver.getWindowHandle();
		
		Actions action=new Actions(driver);
		WebElement search= driver.findElement(By.linkText("Download"));
		
		
		action.moveToElement(search).keyDown(Keys.CONTROL).click().perform();
		Set<String> allWin=driver.getWindowHandles();
		java.util.Iterator<String> itr=allWin.iterator();
		while(itr.hasNext())
		{
			String ID=itr.next();
					System.out.println(ID);
					if(!(ID.equals(ParentID)))
					{
						driver.switchTo().window(ID);
						System.out.println("You are on "+driver.getTitle());
						driver.close();   // CLosing Tab/Window
					}
			driver.switchTo().window(ParentID);						
		}
	}
}
