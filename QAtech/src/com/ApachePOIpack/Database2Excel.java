package com.ApachePOIpack;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class Database2Excel {
    public static void main(String[] args) throws SQLException, IOException {

        //connect to database

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost :3306/world");

        //Write query/statement
        Statement stmt = con.createStatement();

        //Get the result
        ResultSet result = stmt.executeQuery("select * from locations");

        //Excel creation
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Locations Data");

        XSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("LOCATION_ID");
        row.createCell(0).setCellValue("STREET");
        row.createCell(0).setCellValue("PINCODE");
        row.createCell(0).setCellValue("STATE");

        int r = 1;
        while (result.next()){
            int locid = result.getInt("LOCATION_ID");
            String street = result.getString("STREET");
            Double pincode = result.getDouble("PINCODE");
            String state = result.getString("STATE");

            row = sheet.createRow(r++);
            row.createCell(0).setCellValue(locid);
            row.createCell(1).setCellValue(street);
            row.createCell(2).setCellValue(pincode);
            row.createCell(3).setCellValue(state);
        }

        FileOutputStream fos = new FileOutputStream(".\\datafiles\\location.xlsx");
        workbook.write(fos);
        workbook.close();


    }
}
