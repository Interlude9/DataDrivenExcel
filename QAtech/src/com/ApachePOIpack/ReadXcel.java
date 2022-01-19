package com.ApachePOIpack;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadXcel {

    public static void main(String[] args) throws IOException {
        String excelFilepath = ".\\datafiles\\Book1.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilepath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        XSSFSheet sheet = workbook.getSheetAt(0);

        int rows = sheet.getLastRowNum();
        int col = sheet.getRow(1).getLastCellNum();
        for (int i = 0; i < rows ; i++) {
            XSSFRow row = sheet.getRow(i);

            for (int j = 0; j < col; j++) {
                XSSFCell cell = row.getCell(j);
                switch (cell.getCellType()){
                    case STRING -> System.out.print(cell.getStringCellValue());
                    case NUMERIC -> System.out.print(cell.getNumericCellValue());
                    case BOOLEAN -> System.out.print(cell.getBooleanCellValue());
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }



}
