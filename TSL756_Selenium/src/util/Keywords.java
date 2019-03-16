package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Keywords {
	private WebDriver driver;
  @Test
  public Keywords(WebDriver driver ) {
	  
	this.driver = driver;  
	  
  }
  
  public By element (String value)
  {
	  By B = null;
	  if(value.endsWith("_:linktext"))
		  B= By.linkText(value.split("_:")[0]);
	  if(value.endsWith("_:xpath"))
		  B= By.xpath(value.split("_:")[0]);
	  if(value.endsWith("name"));
	  B=By.name(value.split("_:")[0]);
	  if(value.endsWith("_:id"));
	  B=By.id(value.split("_:")[0]);
	return B;  
  }
  
  
  public void openurl(String url) {
	  driver.get(url);
  }
  
  public void type (String locator, String Value) {
	  
	  driver.findElement(element (locator)).sendKeys(Value);
  }
  
  public void click (String locator) {
	  driver.findElement(element(locator)).click();
  }
  
 /* public void dropdown(String locator, String visibletext) {
	  
	  new Select(element(locator)).selectByVisibleText(visibletext);
  }*/
  
}
