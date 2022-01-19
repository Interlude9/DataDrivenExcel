package com.ApachePOIpack;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class excelToDatabase {



    public excelToDatabase() throws SQLException, IOException {
        //Database connection
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3360/world","","");
        Statement stmt = con.createStatement();

        //create a new table in the database 'places'
        String sql = "create table places (LOCATION_ID decimal(4,0), STREET varchar(40), PINCODE decimal(6,0), STATE varchar(40))";
        stmt.execute(sql);

        //Excel
        FileInputStream fis = new FileInputStream(".\\datafiles\\locations.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Locations Data");

        int rows = sheet.getLastRowNum();
    }
}
