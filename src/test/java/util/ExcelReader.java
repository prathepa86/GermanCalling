package util;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
 public static Object[][] readDataFromExcel(String dataExcelName) {
	 Object[][] data=null;
	 FileInputStream oFis;
	 try {
		 
	    oFis=new FileInputStream("./data/"+dataExcelName+".xlsx");
		XSSFWorkbook oWorkbook=new XSSFWorkbook(oFis);
		XSSFSheet oSheet = oWorkbook.getSheetAt(0);
		int lastRowNum = oSheet.getLastRowNum();
		
		short lastCellNum = oSheet.getRow(0).getLastCellNum();
		data=new Object[lastRowNum][lastCellNum];
		for(int i=1;i<=lastRowNum;i++) {
			XSSFRow oRow = oSheet.getRow(i);
			for(int j=0;j<lastCellNum;j++) {
				XSSFCell oCell = oRow.getCell(j);
				String stringCellValue = oCell.getStringCellValue();
				data[i-1][j]=stringCellValue;
			}
		}
		 oFis.close();
		 oWorkbook.close();
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}

	 return data;
 }
}
