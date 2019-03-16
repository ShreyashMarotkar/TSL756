package Day7;

import java.util.Set;
import util.Base;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

public class CookieTest extends Base {
  @Test
  public void Google()
  {
	 driver.get("https://www.google.com/");
	Set<Cookie>allCookies=driver.manage().getCookies();
	for(Cookie C:allCookies)
	{
		System.out.println("Cookie Name is"+C.getName());
		System.out.println("Cookie Domain is"+C.getDomain());
		System.out.println("Cookie Expiry is"+C.getExpiry());
		System.out.println("Cookie Value is"+C.getValue());
		System.out.println("Cookie Path is"+C.getPath());
	}
	  
  }
}
