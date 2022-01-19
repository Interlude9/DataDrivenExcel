package com.ApachePOIpack;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class ReadPasswordProtectedExcel {
    public static void main(String[] args) throws IOException {
        String filepath = ".\\datafiles\\customers.xlsx";
        FileInputStream inputStream = new FileInputStream(filepath);
        //XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        String password = "test123";
        XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(inputStream,password);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();

        for (int r = 0; r <= rows; r++) {

            XSSFRow row = sheet.getRow(r);
            for (int c = 0; c < cols; c++) {

                XSSFCell cell=row.getCell(c);
                switch (cell.getCellType()){
                    case NUMERIC -> System.out.print(cell.getNumericCellValue());
                    case STRING ->  System.out.print(cell.getStringCellValue());
                    case BOOLEAN -> System.out.print(cell.getBooleanCellValue());
                    case FORMULA -> System.out.print(cell.getNumericCellValue());
                }
                System.out.print(" | ");
            }
            System.out.println();
        }

        workbook.close();
        inputStream.close();
    }
}
