package util;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.DesiredCapabilties;
public class Grid  {
  @Test
  public void f() throws Exception{
	  DesiredCapabilities dc=DesiredCapabilities.chrome();
	  dc.setPlatform(Platform.WINDOWS);
	  dc.setBrowserName("chrome");
	  
	  WebDriver driver=new RemoteWebDriver(new URL("http://192.168.100.134:27258/wd/hub"),dc);
	  driver.get("https://www.seleniumhq.org/");
	   Assert.assertEquals(driver.getTitle(),"Selenium - Web Browser Automation" );
			  driver.quit();
  }
}
