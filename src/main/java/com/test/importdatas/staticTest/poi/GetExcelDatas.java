package com.test.importdatas.staticTest.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GetExcelDatas {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\29097\\Desktop\\task\\sz\\通道基础数据.xls");//正常查询
        //获得该文件的输入流
        FileInputStream stream = new FileInputStream(file);
        // 多态  抛异常
//        Workbook sheets = new XSSFWorkbook(stream);
        Workbook sheets = new HSSFWorkbook(stream);
        //获取一个工作表(sheet页)，下标从0开始
        Sheet sheet = sheets.getSheetAt(0);
        for (int i = 1; i<=sheet.getLastRowNum() ; i++) {
            // 获取行数
            Row row = sheet.getRow(i);

            row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
//            row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(10).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(11).setCellType(Cell.CELL_TYPE_STRING);
//            row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
            String code = row.getCell(0).getStringCellValue();
            String name = row.getCell(1).getStringCellValue();
//            String start= row.getCell(2).getStringCellValue();
            String lon= row.getCell(10).getStringCellValue();
            String lat= row.getCell(11).getStringCellValue();
            String sql = "insert into C_Bridge(ID,CODE,NAME,BRITYPE,YHOFFICEID,XCOFFICEID,LON,LAT,ISDELETE) values (NEWID(),'"+code+"','"+name+"','04','0003','0004','"+lon+"','"+lat+"','0');";

            System.out.println(sql);

        }
        //关流
        sheets.close();
        stream.close();
    }
}
