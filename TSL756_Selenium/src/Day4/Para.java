package Day4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.BrowserSetup;
import util.Excel;

public class Para {
	WebDriver driver;
	Connection C;
	PreparedStatement stmt;

	@Test(dataProvider = "dp")
	public void Login(String UN, String PWD) throws SQLException {
		driver.get("http://127.0.0.1:8080/htmldb");
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys(UN);
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys(PWD);
		driver.findElement(By.xpath("//*[@value='Login']")).click();
		stmt=C.prepareStatement("Update login set status=? where UN=? and PWD=?");
		stmt.setString(2, UN);
		stmt.setString(3, PWD);	
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.partialLinkText("Log")).click();

	}

	@DataProvider
	public Object[][] dp() throws Exception {

		Object data[][] = new Object[4][2];
		Excel excel = new Excel("D:\\abc.xlsx");

		for (int i = 0; i <= excel.rowCount("Sheet1"); i++) {
			data[i][0] = excel.Read("Sheet1", i, 0);

			data[i][1] = excel.Read("Sheet1", i, 1);
		}
		return data;
	}

	@AfterMethod
	public void AfterMethod(ITestResult result)
	{
		System.out.println(ITestResult.FAILURE);
		System.out.println(ITestResult.SUCCESS);
		System.out.println(ITestResult.SKIP);
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			System.out.println("Taking ScreenShot");
			BrowserSetup.getScreenShot(result.getName());
		}
	}	
	
	
	@BeforeTest
	public void beforeTest() {
		driver = BrowserSetup.browserStart("chrome");
	}

	@AfterTest
	public void afterTest() {

	}

}
