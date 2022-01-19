package com.ApachePOIpack;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


// Workbook-->Sheet-->Rows-->Cells
public class WriteExcel1 {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Emp Info");

        Object empdata[][] = { {"Empno.","EmpName","Zodiac", "Age" },
                {101, "Leon", "Aries",27 },
                {102, "Toshi", "Aquarius", 23},
                {103, "Dew", "Gemini", 24},
                {104, "Tez", "Leo", 26}
        };

        //For Loop

        /*int rows = empdata.length;
        int cols = empdata[0].length;

        System.out.println("rows "+rows +"cols:" +cols);

        for (int r=0; r<rows;r++){
            XSSFRow row = sheet.createRow(r);
            for (int c = 0; c < cols; c++) {
                XSSFCell cell = row.createCell(c);
                Object value = empdata[r][c];

                if(value instanceof String)
                    cell.setCellValue((String) value);
                if(value instanceof Integer)
                    cell.setCellValue((Integer) value);
                if (value instanceof Boolean)
                    cell.setCellValue((Boolean)value);
            }
        }*/

        /// using for..each loop
        int rowCount=0;

        for (Object emp[]:empdata) {
            XSSFRow row = sheet.createRow(rowCount++);
            int columnCount=0;
            for (Object value:emp
                 ) {
                XSSFCell cell = row.createCell(columnCount++);

                if (value instanceof String)
                    cell.setCellValue((String) value);
                if (value instanceof Integer)
                    cell.setCellValue((Integer)value);
                if (value instanceof Boolean)
                    cell.setCellValue((Boolean)value);
            }
        }

        String filepath = ".\\datafiles\\employee.xlsx";
        FileOutputStream outputStream = new FileOutputStream(filepath);
        workbook.write(outputStream);

        outputStream.close();
        System.out.println("Excel written successfully");

    }
}
