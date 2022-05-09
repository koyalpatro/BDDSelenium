package TestScripts;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestRunner.TestRunner;
import Utility.ExcelHandler;
import Utility.TestDataHandler;
import Utility.excelReader;
import baseClass.BaseClass;
import stepDefinitions.DesiredCapabilities;

public class GooglePageValidation extends BaseClass {
 private WebDriver driver;
 
 
	public GooglePageValidation(WebDriver driver) throws IOException
	{
			
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//input[contains(@name,'q')]")
	public WebElement SearchTextbox;
	
	public void EnterSearch() throws Exception
	{
		
		System.out.println(readExcel("MyDemo").get("Name"));
		EnterText(SearchTextbox, readExcel("MyDemo").get("Name"));
	}
	
	
}
