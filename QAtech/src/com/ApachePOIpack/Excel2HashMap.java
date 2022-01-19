package com.ApachePOIpack;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Excel2HashMap {
    public static void main(String[] args) throws IOException {
        String filepath = ".\\datafiles\\student.xlsx";
        FileInputStream fis = new FileInputStream(filepath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int rows = sheet.getLastRowNum();

        HashMap<String, String> hmap = new HashMap();

        // Reading from excel to hmap

        for (int r = 0; r < rows; r++) {
            String key = sheet.getRow(r).getCell(0).getStringCellValue();
            String value = sheet.getRow(r).getCell(1).getStringCellValue();
            hmap.put(key,value);

        }

        for (Map.Entry value:hmap.entrySet()) {
            System.out.println(value.getKey() +" | " +value.getValue());
        }
    }
}
