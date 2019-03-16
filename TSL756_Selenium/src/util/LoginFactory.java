package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginFactory {
	LoginFactory (WebDriver idriver){
		PageFactory.initElements(idriver, this);
		}
	
@FindBy(name = "p_t01") WebElement e_username;	
@FindBy(name = "p_t02") WebElement e_password;			
@FindBy(xpath = "//*[@value = 'Login']") WebElement e_login;		
		
  @Test
  public void LoginProcess(String un , String pwd) {
	  
	e_username .sendKeys(un);
	e_password.sendKeys(pwd);
	e_login.click();
	 	  
  }
}
