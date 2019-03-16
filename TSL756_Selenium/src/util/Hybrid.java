package util;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class Hybrid extends Base2{
  @Test(dataProvider = "dp")
  public void f(String key, String locator,String data) {
	  Keywords k1=new Keywords(driver);
	  switch(key)
	  {
	  case "openUrl":
	  k1.openurl(data);
	  break;
	  
	  case "type":
		  k1.type(locator,data);
		  break;
	  
	  case "click":
		  k1.click(locator);
		  break;
	  }
  }

  @DataProvider
  public Object[][] dp() {
	  Excel ex = new Excel ("D:\\BOOK11.xls");
	   Object data[][]=new Object[ex.rowCount("Sheet1")+1][3];
	  for(int i=0;i<ex.rowCount("Sheet1");i++)
{
		  data[i][0]=ex.Read("Sheet1", i+1, 0);
		  data[i][1]=ex.Read("Sheet1", i+1, 1);
		  data[i][2]=ex.Read("Sheet1", i+1, 2);
	  }
    return data;
     

  }
}

