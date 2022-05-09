package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReader {

	public static List<Map<String, String>> getMapData() throws IOException{
		List<Map<String, String>> dataTable=null;
		Map<String,String> testData= null;
	try {
		String projectPath=System.getProperty("user.dir");
		String excelfilePath="\\src\\main\\resources\\TestData\\Demo.xlsx";
		FileInputStream fileinputStream =new FileInputStream(projectPath+excelfilePath);
		Workbook workbook =new XSSFWorkbook(fileinputStream); 
		Sheet sheet=workbook.getSheet("MyDemo");
		int lastRowNumber=sheet.getLastRowNum();
		int lastColNumber=sheet.getRow(0).getLastCellNum();
		
		List<String> list=new ArrayList<String>();
		
		for (int i = 0; i < lastColNumber; i++) {
			Row row=sheet.getRow(0);
			Cell cell=row.getCell(i);
			String RowHeader=cell.getStringCellValue().trim();
			list.add(RowHeader);
		}
		dataTable =new ArrayList<Map<String,String>>();
		for (int j = 1; j <lastRowNumber; j++) {
			Row row=sheet.getRow(j);
			testData=new TreeMap<String,String>(String.CASE_INSENSITIVE_ORDER);
			for (int k = 0; k < lastColNumber; k++) {
			Cell cell=row.getCell(k);
			String colValue=cell.getStringCellValue().trim();
			testData.put((String) list.get(k), colValue);
			}
			dataTable.add(testData);
		}
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
	return dataTable;
}
	
	}
