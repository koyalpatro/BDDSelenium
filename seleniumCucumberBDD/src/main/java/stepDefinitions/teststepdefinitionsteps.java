package stepDefinitions;

import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import TestScripts.GooglePageValidation;
import Utility.PropertiesReader;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class teststepdefinitionsteps {
	private WebDriver driver;
	PropertiesReader obj=new PropertiesReader();
	@Given("^Open chrome browser and enter url$")
	public void open_chrome_browser_and_enter_url() throws Throwable 
	{
		/*
		 * Properties properties=obj.getProperty(); String
		 * s=properties.getProperty("browser.URL");
		 * driver=DesiredCapabilities.OpenBrowser(driver);
		 */
		driver=DesiredCapabilities.OpenBrowser();
				
		if(driver!=null) {
			System.out.println();
		}
			 	   
	}

	@When("^Enter search creteria$")
	public void enter_search_creteria() throws Throwable 
	{
		GooglePageValidation g= new GooglePageValidation(driver); 
		g.EnterSearch();
	  
		
	}
	
	
	

	
}
