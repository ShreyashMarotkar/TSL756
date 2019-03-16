package util;
import util.Keywords;
import org.testng.annotations.Test;

public class Executethis extends Base2{
  @Test
  public void f() {
	  Keywords key = new Keywords(driver);
	  key.openurl("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	  key.type("txtUsername_name", "admin");
	  key.type("txtPassword_id", "admin123");
	  key.click("btnLogin_id");
  }
}
