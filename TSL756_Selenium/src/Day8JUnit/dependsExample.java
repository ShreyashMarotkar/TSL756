package Day8JUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.Base;

public class dependsExample extends Base{
	
 
@Test
  public void f1() {
	 
	  System.out.println("In Test 1");
	  driver.get("http://google.com");
	  Assert.assertEquals(driver.getTitle(), "Google");
	//  Assert.assertTrue(true);
  }
  
  @Test (dependsOnMethods="f1")
  public void f2() {
	  boolean display = driver.findElement(By.name("q")).isDisplayed();
	  Assert.assertTrue(display);
  }
  
  @Test (dependsOnMethods="f2")
  public void f3() throws Exception {
	  String data = "HOW TO";
	  System.out.println("In Test 3");
	  driver.findElement(By.name("q")).sendKeys(data);
	// new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("btnk")));
	  driver.findElement(By.name("btnK")).click();
	 // Assert.assertEquals(driver.getTitle(), data+" - Google Search");
	  Assert.assertTrue(driver.getTitle().contains(data));
  }
}
