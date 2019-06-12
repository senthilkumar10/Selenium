package week5;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import wdMethods.ProjectMethod;


public class CreateLead_Se_TNG_small extends ProjectMethod{

	//@Test(groups = "smoke",dataProvider="fetchdata")
		
	@Test(dataProvider="fetchdata")
	public void createLeadTC(String cn,String fn, String ln) throws Exception
	{
		
		click(locateElement("linktext","Leads"));
		click(locateElement("linktext","Create Lead"));
		type(locateElement("id", "createLeadForm_companyName"), cn);
		type(locateElement("id", "createLeadForm_firstName"), fn);
		type(locateElement("id", "createLeadForm_lastName"), ln);
		click(locateElement("class","smallSubmit"));
		
	}
	
	@DataProvider(name = "fetchdata")
	public String[][] getdata() throws InvalidFormatException, IOException
	{
		File src = new File("./testdata/CLdata.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(src);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[rowcount][colcount];
		System.out.println("Row Count = "+rowcount);
		System.out.println("Column Count = "+colcount);
		for (int i = 1; i <=rowcount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < colcount; j++) {
				XSSFCell cell=	row.getCell(j);
				data[i-1][j] = cell.getStringCellValue();
				//System.out.println(value);
			}

		}wb.close();


		return data;
	}
	
}
