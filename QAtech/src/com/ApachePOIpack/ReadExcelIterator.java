package com.ApachePOIpack;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ReadExcelIterator {

    public static void main(String[] args) throws IOException {
        String excelfilepath2 = ".\\datafiles\\Book1.xlsx";
        FileInputStream inputStream = new FileInputStream(excelfilepath2);

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator iterator = sheet.iterator();
        while (iterator.hasNext())
        {
            XSSFRow row = (XSSFRow) iterator.next();
            Iterator cellIter = row.cellIterator();
            while (cellIter.hasNext()){
                XSSFCell cell = (XSSFCell)cellIter.next();
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
