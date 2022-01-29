package com.java.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings("deprecation")
public class ExcelUtility {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	// This method is to set the File path and to open the Excel file, Pass
	// Excel Path and Sheetname as Arguments to this method
	public static void setExcelFile(String Path, String SheetName) {
		try {
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			if (ExcelWSheet == null) {
				ExcelWSheet = ExcelWBook.createSheet(SheetName);
			}
		} catch (Exception e) {
			Log.info("An error occured while performing setExcelFile("+ Path + ", " + SheetName + ")");
			Log.writeStackTrace(e);
		}
	}


	public static int getRowCount() {
		return ExcelWSheet.getLastRowNum();
	}
	
	public static int getRowCount(String dataProvider, String fileName) {
		setExcelFile(dataProvider, fileName);
		return ExcelWSheet.getLastRowNum();
	}

	public static int getColumnCount() {
		return ExcelWSheet.getRow(0).getLastCellNum();
	}


	public static String getCellData(int colNameRow, String colName, int rowNum) {
		try {
			DataFormatter DFMT = new DataFormatter();
			
			Log.info("Trying to Fetch Data From: " + ExcelWSheet.getSheetName() + " sheet at Row: " + rowNum + " & Column: " + colName);
			int col_Num = -1;
			Row = ExcelWSheet.getRow(colNameRow);
			for (int i = 0; i < Row.getLastCellNum(); i++) {
				if (Row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num = i;
			}
			Row = ExcelWSheet.getRow(rowNum);
			Cell = Row.getCell(col_Num);
			if (Cell.getCellTypeEnum() == CellType.STRING) {
			Log.info("Excel Sheet Returned Value as: " + DFMT.formatCellValue(Cell)); 
				return DFMT.formatCellValue(Cell);
			} else if (Cell.getCellTypeEnum() == CellType.NUMERIC || Cell.getCellTypeEnum() == CellType.FORMULA) {
				String cellValue = DFMT.formatCellValue(Cell);
				if (HSSFDateUtil.isCellDateFormatted(Cell)) {
					DateFormat df = new SimpleDateFormat("dd/MM/yy");
					Date date = Cell.getDateCellValue();
					cellValue = df.format(date);
				}
				Log.info("Excel Sheet Returned Value as: " + cellValue); 
				return cellValue;
			} else if (Cell.getCellTypeEnum() == CellType.BLANK) {
				Log.info("Excel Sheet Returned Null"); 
				return "";
			} else
				return String.valueOf(Cell.getBooleanCellValue());
		} catch (IllegalArgumentException e) {
			return null;
		} catch (Exception e) {
			Log.writeStackTrace(e);
			return "";
		}
	}


	@SuppressWarnings("static-access")
	public static int searchStringRowNum(String fileName, String sheetName, String stringToSearch) throws IOException {

		FileInputStream inputStream = new FileInputStream(fileName);
		Workbook workbook = new XSSFWorkbook(inputStream);

		Sheet firstSheet = workbook.getSheet(sheetName);
		Iterator<Row> iterator = firstSheet.iterator();
		int rowNumber = 0;
		boolean found =false;
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					String text = cell.getStringCellValue();
					if (stringToSearch.equals(text)) {
						rowNumber = cell.getRowIndex();
						found=true;
						break;
					}
				}
			}
			if(found){break;}
		}
		workbook.close();
		return rowNumber;
	}
	
}