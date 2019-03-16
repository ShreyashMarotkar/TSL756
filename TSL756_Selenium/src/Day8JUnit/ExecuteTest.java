package Day8JUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.Base2;

public class ExecuteTest extends Base2 {
  @Test
  public void LoginTest() {
	  Login in=new Login(driver);
	  driver.get("http://127.0.0.1:8080/htmldb");
	  in.LoginProcess("sys", "Newuser123");
  }
  
  @Test(dependsOnMethods="LoginTest")
  public void RunQueryTest() throws Exception {
	  SQL_Command command=new SQL_Command(driver);
	  command.RunQueryProcess("select * from tab");
	  Assert.assertTrue(driver.findElement(By.xpath("//*[text()='TNAME']")).isDisplayed());
	  command.logoutProcess();
  }
}
  
  
