package Utility;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import config.Constants;


public class ExecuteTestcases {
	public static Properties OR;
	//public static ActionKeywords actionKeywords;
	public static String sActionKeyword;
	public static String sPageObject;
	public static Method method[];

	public static int iTestStep;
	public static int iTestLastStep;
	public static String sTestCaseID;
	public static String sRunMode;

	/*
	 * public ExecuteTestcases() throws NoSuchMethodException, SecurityException{
	 * actionKeywords = new ActionKeywords(); method =
	 * actionKeywords.getClass().getMethods(); }
	 */
    public static void main(String[] args) throws Exception {
    	String projectPath=System.getProperty("user.dir");
		String testDataFilePath="\\src\\main\\resources\\TestData\\Demo.xlsx";
		String testDataFile=projectPath+testDataFilePath;
    	ExcelUtility.setExcelFile(testDataFile);

		/*
		 * //String Path_OR = Constants.Path_OR; FileInputStream fs = new
		 * FileInputStream(Path_OR); OR= new Properties(System.getProperties());
		 * OR.load(fs);
		 */

		ExecuteTestcases startEngine = new ExecuteTestcases();
		startEngine.execute_TestCase();
    }

    public static Map<String, String> execute_TestCase() throws Exception {
    	Map<String, String> dataTable=null;
    	String projectPath=System.getProperty("user.dir");
		String testDataFilePath="\\src\\main\\resources\\TestData\\Demo.xlsx";
		String testDataFile=projectPath+testDataFilePath;
    	ExcelUtility.setExcelFile(testDataFile);
    	
		//This will return the total number of test cases mentioned in the Test cases sheet
    	int iTotalTestCases = ExcelUtility.getRowCount(Constants.Sheet_TestCases);
		//This loop will execute number of times equal to Total number of test cases
    	int lastColNumber=ExcelUtility.getColCount(Constants.Sheet_TestCases);
		for(int iTestcase=1;iTestcase<=iTotalTestCases;iTestcase++){
			//This is to get the Test case name from the Test Cases sheet
			sTestCaseID = ExcelUtility.getCellData(iTestcase, Constants.Col_TestCaseID, Constants.Sheet_TestCases); 
			//This is to get the value of the Run Mode column for the current test case
			sRunMode = ExcelUtility.getCellData(iTestcase, Constants.Col_RunMode,Constants.Sheet_TestCases);
			//This is the condition statement on RunMode value
			if (sRunMode.equals("Yes")){
				//Only if the value of Run Mode is 'Yes', this part of code will execute
				/*
				 * List<String> list=new ArrayList<String>();
				 * 
				 * for (int i = 0; i < lastColNumber; i++) { String
				 * RowHeader=ExcelUtility.getCellData(0,i,Constants.Sheet_TestCases).trim();
				 * list.add(RowHeader); }
				 * 
				 * dataTable =new ArrayList<Map<String,String>>(); testData=new
				 * TreeMap<String,String>(String.CASE_INSENSITIVE_ORDER); for (int k = 0; k <
				 * lastColNumber; k++) { String
				 * colValue=ExcelUtility.getCellData(iTestcase,k,Constants.Sheet_TestCases).trim
				 * (); testData.put((String) list.get(k), colValue); } dataTable.add(testData);
				 */
				
				dataTable=ExcelHandler.getTestDataInMap(testDataFile, Constants.Sheet_TestCases, sTestCaseID);
		    			
					}
    			}
		return dataTable;
    		}

    
}
