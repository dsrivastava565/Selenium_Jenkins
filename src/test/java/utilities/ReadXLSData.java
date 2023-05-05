package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadXLSData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ReadXLSData red = new ReadXLSData();
		red.getData("Sheet1");
		// TODO Auto-generated method stub

	}
	public String[][] getData(String sheetname) throws EncryptedDocumentException, IOException {
		File f = new File("/Users/deveshsrivastava/Documents/fresh-workspace/testframework/src/test/resources/testdata/testdata.xlsx");
		FileInputStream fI = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fI);
		Sheet sheetName = wb.getSheet(sheetname);
		
		System.out.println(System.getProperty("user.dir")+"/src/test/resources/testdata/testdata.xlsx");
		int totalRows = sheetName.getLastRowNum();
		System.out.println(totalRows);
		Row rowCells = sheetName.getRow(0);
		int totalCells = rowCells.getLastCellNum();
		System.out.println(totalCells);
		DataFormatter format = new DataFormatter();
		String[][] testData = new String[totalRows][totalCells];
		for(int i=1;i<=totalRows;i++) {
			for(int j = 0;j<totalCells;j++) {
				
				testData[i-1][j]= format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testData[i-1][j]);
			}
		}
		return testData;
	}

}
