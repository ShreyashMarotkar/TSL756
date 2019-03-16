package day4NG;

import org.testng.annotations.Test;

import util.BrowserSetup;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class FirstNG {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("https://www.google.com");
	  String title=driver.getTitle();
	  Assert.assertEquals(title, "Google");
	  
  }
  @Test(priority=2,description="Search Box Detail Testing")
  public void searchBoxTest()
  {
	  WebElement E=driver.findElement(By.name("q"));
	  Assert.assertEquals(E.isDisplayed(),true);
	  Assert.assertEquals(E.isEnabled(),true);
	  Assert.assertEquals(E.getAttribute("maxlength"),"2048","Max lenght not match");
  }
  @BeforeTest
  public void beforeTest() {
	   driver=BrowserSetup.browserStart("chrome");
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
