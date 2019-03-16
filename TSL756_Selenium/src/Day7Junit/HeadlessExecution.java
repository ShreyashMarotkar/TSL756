package Day7Junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import util.Base;

public class HeadlessExecution extends Base {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		FirefoxOptions op = new FirefoxOptions();
		op.addArguments("--headless");
		op.addArguments("--start-maximize");
		driver = new FirefoxDriver(op);
		driver.manage().window().maximize();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		
		driver.get("http://google.com");
		assertEquals("Google",driver.getTitle());
		assertTrue(driver.findElement(By.linkText("Maven users")).isDisplayed());
	}

}
