package week5;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class LearnExcel {

	@Test
	public void readExcel() throws InvalidFormatException, IOException
	{
		File src = new File("./testdata/CLdata.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(src);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();
		System.out.println("Row Count = "+rowcount);
		System.out.println("Column Count = "+colcount);
		for (int i = 1; i <=rowcount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < colcount; j++) {
				XSSFCell cell=	row.getCell(j);
				String value = cell.getStringCellValue();
				System.out.println(value);
			}


		}wb.close();




	}

}
