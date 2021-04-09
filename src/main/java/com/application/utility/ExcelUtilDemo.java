package com.application.utility;

public class ExcelUtilDemo {

	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");
		ExcelUtils excel = new ExcelUtils(projectPath+"/ExcelFolder/data.xlsx", "Sheet1");


		excel.getRoCount();
		excel.getCellDataString(0, 1);
		excel.getCellDataNumeric(1, 1);
	}

}
