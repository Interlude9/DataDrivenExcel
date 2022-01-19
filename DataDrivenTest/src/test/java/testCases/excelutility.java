package testCases;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class excelutility {

    public FileInputStream fi;
    public FileOutputStream fo;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;
    public String path;


    excelutility(String path){
        this.path=path;
    }


    public int getRowCount(String sheetname) throws IOException {
        fi= new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet= workbook.getSheet(sheetname);
        int rowcount= sheet.getLastRowNum();
        workbook.close();
        fi.close();
        return rowcount;
    }

    public int getCellCount(String sheetName,int rownum) throws IOException {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet= workbook.getSheet(sheetName);
        row= sheet.getRow(rownum);
        int cellcount = row.getLastCellNum();
        workbook.close();
        fi.close();
        return cellcount;
    }

    public String getCellData(String sheetname, int rownum, int cellcount) throws IOException {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetname);
        row= sheet.getRow(rownum);
        row.getCell(cellcount);

        DataFormatter formatter = new DataFormatter();
        String data;
        try{
            data = formatter.formatCellValue(cell);//Returns the formatted value of a cell as a String
            //regardless of the cell type
        }
        catch (Exception e){
            data="";
        }
        workbook.close();
        fi.close();
        return data;
    }

    public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rownum);
        cell = row.createCell(colnum);
        cell.setCellValue(data);

        fo=new FileOutputStream(path);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }


















}
