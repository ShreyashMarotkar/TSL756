package util;

import org.testng.annotations.Test;

public class Executeion extends Base2 {
  @Test
  public void f()  {
	LoginFactory LF = new LoginFactory(driver);
	driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:15475849987882384931::NO:");
	LF.LoginProcess("sys", "Newuser123"); 
	 
  }
   @Test
  public void f1() {
	  
	  LinkTest Lt=new LinkTest(driver);
	  driver.get("http://newtours.demoaut.com");
	  Lt.CheckLink();
	  
  }
}
