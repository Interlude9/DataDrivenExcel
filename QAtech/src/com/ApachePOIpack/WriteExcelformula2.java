package com.ApachePOIpack;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcelformula2 {
    public static void main(String[] args) throws IOException {
        String filepath = ".\\datafiles\\books.xlsx";

        // Here data is already present in the excel sheet

        FileInputStream fis = new FileInputStream(filepath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        sheet.getRow(7).getCell(2).setCellFormula("SUM(C2:C6)");
        fis.close();

        FileOutputStream fos = new FileOutputStream(filepath);
        workbook.write(fos);
        workbook.close();
        fos.close();
        System.out.println("Done:P");

    }
}
