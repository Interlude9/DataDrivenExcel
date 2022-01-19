package com.ApachePOIpack;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFormulacell {
    public static void main(String[] args) throws IOException {

        String filepath = ".\\datafiles\\readformula.xlsx";
        FileInputStream inputStream = new FileInputStream(filepath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        XSSFSheet sheet = workbook.getSheetAt(0);
        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();

        for (int r = 0; r < rows; r++) {
            XSSFRow row = sheet.getRow(r);

            for (int c = 0; c < cols; c++) {
                XSSFCell cell = row.getCell(c);

                switch (cell.getCellType()){
                    case STRING -> System.out.print(cell.getStringCellValue());
                    case NUMERIC -> System.out.print(cell.getNumericCellValue());
                    case BOOLEAN -> System.out.print(cell.getBooleanCellValue());
                    case FORMULA -> System.out.print(cell.getNumericCellValue());
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
        inputStream.close();
    }
}
