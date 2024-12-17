package com.Vtiger_GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FetchExcelfile {

	FileInputStream fi = null;

	FileOutputStream fos = null;

	// Workbook wb = null;

	XSSFWorkbook wb = null;

	public String getDataFromExcelfile(String sheetname, int Rows, int cells) {
		try {

			fi = new FileInputStream("./src/test/resources/Excel/Selenium.xlsx");
			System.out.println(fi);

		} catch (FileNotFoundException e) {

			System.out.println("Failed to load the Excel file");
		}

		try {

			wb = new XSSFWorkbook(fi);

			// wb = WorkbookFactory.create(fi);
			System.out.println(wb);

		} catch (Exception e) {
			System.out.println("Failed to load the workbook");
		}

		Sheet sh = wb.getSheet(sheetname);

		System.out.println(sh);

		Row r = sh.getRow(Rows);

		Cell c = r.getCell(cells);

		String data = c.getStringCellValue();

		try {
			
			wb.close();
			
		} catch (IOException e) {
			
			System.out.println("Close the excel file");
		}

		return data;

	}

	public void WriteDataBackTopropertyfile(String Sheetname, int Roi, int Celi, String data1) {

		try {

			fi = new FileInputStream("./src/test/resources/Excel/Selenium.xlsx");

			System.out.println(fi);

		} catch (FileNotFoundException e) {

			System.out.println("Failed to load the Excel file");
		}

		try {

			wb = new XSSFWorkbook(fi);

		} catch (IOException e) {

			System.out.println("Failed to load the workbook");
		}

		Sheet sh = wb.getSheet(Sheetname);

		Row r = sh.createRow(Roi);

		Cell c = r.createCell(Celi);

		c.setCellValue(data1);

		try {

			fos = new FileOutputStream("./src/test/resources/Excel/Selenium.xlsx");

			wb.write(fos);

		} catch (Exception e) {

			System.out.println("Check the dependency");
		}

		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
