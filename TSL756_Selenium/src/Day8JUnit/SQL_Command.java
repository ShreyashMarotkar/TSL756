package Day8JUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SQL_Command {
	private WebDriver driver;
	public SQL_Command(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	private By e_Logout=By.linkText("Logout");
	private By e_sql=By.linkText("SQL");
	private By e_sqlCommand=By.linkText("SQL Commands");
	private By e_command=By.id("P1003_SQL_COMMAND1");
	private By e_display=By.linkText("p_t03");
	private By e_run=By.xpath("//*[@value='Run']");
	
	public void RunQueryProcess(String query)
	{
		driver.findElement(e_sql).click();
		driver.findElement(e_sqlCommand).click();
		new Select(driver.findElement(e_display)).selectByVisibleText("50");
		driver.findElement(e_command).sendKeys(query);
		driver.findElement(e_run).click();
	}
	
	public void logoutProcess()
	{
		driver.findElement(e_Logout).click();
	}
}
