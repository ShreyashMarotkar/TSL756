package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

public class DatabaseConnection {
	WebDriver driver;
  @Test
  public void f()throws Exception {
  
	  DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
	  Connection c= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","Newuser123");
	  ResultSet R= c.createStatement().executeQuery("select count(*) from login");
	  R.next();
Object data[][]=new Object[R.getInt(1)][2];	  
	  int i=0;
	  ResultSet R2= c.createStatement().executeQuery("select * from login");
	  
	  while(R2.next()) 
	  {
		data[i][0]=R2.getString(1);
		System.out.println(R2.getString(1));
		data[i][1]=R2.getString(2);
		System.out.println(R2.getString(2));
		i++;
	  }
  
//	  return data;
  }
  @BeforeMethod
  public void beforeMethod()
  {
	  driver=BrowserSetup.browserStart("chrome", "http://127.0.0.1:8080/htmldb");
  }

 @AfterMethod
  public void afterMethod(TestResult result)
  {
	  if(result.getStatus()==TestResult.FAILURE)
	  {
		  System.out.println("Taking ScreenShot");
		  BrowserSetup.getScreenShot(result.getName());
		  
	  }
	  
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
