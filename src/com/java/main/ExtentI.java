/**
 * 
 */
package com.java.main;

import java.util.ArrayList;

public class ExtentI{

	private ExtentI() {
	    throw new IllegalStateException("ExtentI class");
	  }

	// Method to apply filter on excel file based on columns
	public static Object[][] columnbasedfilter(String filename,String sheetName,String[] columnName,String[] filterValue,String... columnstoget){
		ExcelUtility.setExcelFile(filename, sheetName);
		int row=ExcelUtility.getRowCount();
		int counts=0;
		ArrayList<Integer> rowFound = new ArrayList<Integer>();
		for(int i=1;i<=row;i++){
			if(ExcelUtility.getCellData(0, columnName[0], i).equals(filterValue[0])
					&& ExcelUtility.getCellData(0, columnName[1], i).equals(filterValue[1])){counts++;
					rowFound.add(i);}}
		Object[][] myObj = new Object[counts][columnstoget.length];

		counts=0;
		for(int p : rowFound){
			for(int j=0;j<columnstoget.length;j++){
				myObj[counts][j]=ExcelUtility.getCellData(0, columnstoget[j], p);}
			counts++;
		}
		return myObj;
	}
	
}
