package com.ApachePOIpack;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


// Workbook-->Sheet-->Rows-->Cells
public class WriteExcel2 {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("BTS Info");

        ArrayList<Object[]> members = new ArrayList<Object[]>();
        members.add(new Object[]{"Age","Name", "Position"});
        members.add(new Object[]{26,"Tae", "Visual"});
        members.add(new Object[]{28, "Suga", "Rap"});
        members.add(new Object[]{24, "Jungkook", "Vocals"});


        /// using for..each loop
        int rowNum=0;
        for (Object mem[]:members) {
            XSSFRow row = sheet.createRow(rowNum++);
            int cellnum = 0;
            for (Object value:mem) {
                XSSFCell cell = row.createCell(cellnum++);
                if (value instanceof String)
                    cell.setCellValue((String) value);
                if (value instanceof Integer)
                    cell.setCellValue((Integer)value);
                if (value instanceof Boolean)
                    cell.setCellValue((Boolean)value);
            }
        }

        String filepath = ".\\datafiles\\celeb.xlsx";
        FileOutputStream outputStream = new FileOutputStream(filepath);
        workbook.write(outputStream);

        outputStream.close();
        System.out.println("Excel written successfully");

    }
}
