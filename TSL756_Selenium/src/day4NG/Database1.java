package day4NG;

import org.testng.annotations.Test;

import util.BrowserSetup;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;

public class Database1 {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(String n, String s) {
	  driver.get("http://127.0.0.1:8080/htmldb");
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys(n);
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys(s);
		driver.findElement(By.xpath("//*[@value='Login']")).click();
		driver.findElement(By.linkText("Logout")).click();;
		driver.findElement(By.partialLinkText("Log")).click();;
  }

  @DataProvider
  public Object[][] dp() throws SQLException {
	  DriverManager.registerDriver(new oracle.jdbc.OracleDriver() );
	  
		 Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Newuser123");
		 ResultSet r=c.createStatement().executeQuery("Select count(*) from Login");
		r.next();
		System.out.println(r.getInt(1));
		Object data[][]=new Object[r.getInt(1)][2];
		int i=0;
		ResultSet R= c.createStatement().executeQuery("select * from Login");
		while(R.next())
		{
		
			data[i][0]=R.getString(1);
			System.out.println(data[i][0]);
			data[i][1]=R.getString(2);
			System.out.println(data[i][1]);
			i++;
	//		if(data[i][0]==sys||system && data[i][1])
		}
		 return data;
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver = BrowserSetup.browserStart("chrome");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
  @org.testng.annotations.AfterMethod
  public void AfterMethod(ITestResult result)
  {
	  {
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
		  System.out.println("Taking Screenshot");
		  BrowserSetup.getScreenShot(result.getName());;
	  }
  
	  }
  }

}