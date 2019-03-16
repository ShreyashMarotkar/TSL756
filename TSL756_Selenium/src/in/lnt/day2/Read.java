package in.lnt.day2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.BrowserSetup;

public class Read {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver=BrowserSetup.browserStart("firefox","http://127.0.0.1:8080/htmldb/f?p=4550:11:4795779979039793059::NO:::");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	FileInputStream inFile= new FileInputStream("D:\\Book1.xlsx");
	XSSFWorkbook book=new XSSFWorkbook(inFile);
	XSSFSheet Sheet = book.getSheet("Sheet1");
	String data = Sheet.getRow(0).getCell(0).toString();
	String data1 = Sheet.getRow(0).getCell(1).toString();
	System.out.println(""+data);
	driver.findElement(By.id("P11_USERNAME")).sendKeys(data);
	driver.findElement(By.id("P11_PASSWORD")).sendKeys(data1);
	driver.findElement(By.xpath("/html/body/form/div[6]/table/tbody/tr/td[3]/table[2]/tbody/tr/td/input[1]")).click();
	driver.findElement(By.xpath("/html/body/form/a[4]/img")).click();
	}

}
