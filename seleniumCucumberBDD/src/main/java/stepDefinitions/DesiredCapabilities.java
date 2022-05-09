package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utility.ExcelHandler;
import Utility.ExecuteTestcases;
import Utility.excelReader;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class DesiredCapabilities {
	private static WebDriver driver;
	
	public static WebDriver OpenBrowser() throws InterruptedException
	{
		
		String projectPath=System.getProperty("user.dir");
		
			String browserPath="\\src\\main\\resources\\drivers\\Chrome\\chromedriver.exe";
			String path=projectPath+browserPath;
			System.setProperty("webdriver.chrome.driver", path);
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://google.com");
			Thread.sleep(5000);
			return driver;	
			
		}
		
		/*
		 * @Test(dataProvider="testmethod")
		 * 
		 * public void Test(Map<Object,Object> testData) throws IOException { String
		 * runmode=(String) testData.get("RunMode"); if(runmode=="Yes") {
		 * Map<String,String> DataValue=(Map<String, String>) excelReader.getMapData();
		 * } else { System.out.println("Failed"); } }
		 * 
		 * @DataProvider(name="testmethod")
		 * 
		 * public static Object[][] getTestData() throws IOException{ Object[][]
		 * ObjectArray=null; try { List<Map<String, String>>
		 * TestDataAll=excelReader.getMapData(); ObjectArray=new
		 * Object[TestDataAll.size()][1];
		 * 
		 * for(int i=0 ;i<TestDataAll.size();i++) { ObjectArray[i][0]=
		 * TestDataAll.get(i); } } catch (IOException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } return ObjectArray; }
		 */
	
	@BeforeClass()
	

	public static Map<String, String> readExcel(String sheetName) throws Exception {
		System.out.println(sheetName);
		Map<String, String> testdata=null;
		return testdata=ExecuteTestcases.execute_TestCase();
	}
	@After()
	public void teardown() {
		this.driver.quit();
	}
	
	
}
