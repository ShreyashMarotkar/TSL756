package Day8JUnit;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import util.BrowserSetup;

public class ReadProperty {
  @Test
  public void f() throws Exception {
	  Properties prop=new Properties();
	  prop.load(new FileInputStream("D:\\Javaworkspace\\Selenium\\TSL756_Selenium\\Constant.property"));
	  
	  WebDriver driver = BrowserSetup.browserStart("chrome");
	  driver.get(prop.getProperty("URL"));
	  
	  driver.findElement(element(prop.getProperty("e_download"))).click();
  }
  
  public By element(String Value)
  {
	  By B=null;
	  if(Value.endsWith("_linktext"))
		  B = By.linkText(Value.split("_")[0]);
	  else if (Value.endsWith("_xpath"))
		  B= By.xpath(Value.split("_")[0]);
	  return B;
		  
  }
}
