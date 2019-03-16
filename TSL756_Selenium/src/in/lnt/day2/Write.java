package in.lnt.day2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import util.BrowserSetup;

public class Write {

	public static void main(String[] args) throws Exception {
		WebDriver driver=BrowserSetup.browserStart("firefox","http://127.0.0.1:8080/htmldb/f?p=4550:11:4795779979039793059::NO:::");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		FileInputStream inFile= new FileInputStream("D:\\Book1.xlsx");
		
		XSSFWorkbook book=new XSSFWorkbook(inFile);
		XSSFSheet Sheet = book.getSheet("Sheet1");
		
		Sheet.createRow(4).createCell(2).setCellValue("ARZOO");
		Sheet.createRow(5).createCell(1).setCellValue("PRIYANKA");
		Sheet.getRow(3).getCell(1).setCellValue("PRIYANKA");
		
		FileOutputStream op = new FileOutputStream("D:\\Book2.xlsx");
		book.write(op);

	}

}
