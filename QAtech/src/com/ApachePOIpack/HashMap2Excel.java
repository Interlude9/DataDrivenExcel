package com.ApachePOIpack;

import org.apache.pdfbox.pdmodel.interactive.action.PDActionThread;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HashMap2Excel {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("Student data");

        Map<String, String> hmap = new HashMap<String, String>();
        hmap.put("A","Andy");
        hmap.put("B", "Bill");
        hmap.put("C","Cathy");
        hmap.put("D", "Daniel");
        hmap.put("E","Elaine");

        int rownum=0;

        for (Map.Entry entry: hmap.entrySet()){
           XSSFRow row =  sheet.createRow(rownum++);

           row.createCell(0).setCellValue((String) entry.getKey());
           row.createCell(1).setCellValue((String) entry.getValue());
        }
        FileOutputStream fos = new FileOutputStream(".\\datafiles\\student.xlsx");
        workbook.write(fos);
        fos.close();
        System.out.println("Transfer of data from HashMap to Excel done");


    }
}
