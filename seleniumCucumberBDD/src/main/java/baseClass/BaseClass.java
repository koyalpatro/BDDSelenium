package baseClass;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import Utility.ExecuteTestcases;
import cucumber.api.java.After;

public class BaseClass {
private WebDriver driver;
	
 public void clickElement(WebElement element) {
	 element.click();
	 
 }
 
 public void EnterText(WebElement element,String value) {	 
	element.sendKeys(value);
	System.out.println("567");
	
 }
 
 public static Map<String, String> readExcel(String sheetName) throws Exception {
		System.out.println(sheetName);
		Map<String, String> testdata=null;
		return testdata=ExecuteTestcases.execute_TestCase();
	}

}
