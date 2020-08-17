package com.test.importdatas.staticTest.poi;

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
        File file = new File("C:\\Users\\29097\\Desktop\\task\\cf\\20200804 刘明洋 市政养护系统修改121附表1：绿化汇总台账数据增加绿化识别码.xls");//正常查询
        //获得该文件的输入流
        FileInputStream stream = new FileInputStream(file);
        // 多态  抛异常
//        Workbook sheets = new XSSFWorkbook(stream);
        XSSFWorkbook sheets = new XSSFWorkbook(stream);
        //获取一个工作表(sheet页)，下标从0开始
        Sheet sheet = sheets.getSheetAt(0);
        for (int i = 1; i<=sheet.getLastRowNum() ; i++) {
            // 获取行数
            Row row = sheet.getRow(i);

            row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
            String s1 = row.getCell(5).getStringCellValue();
            String s2 = row.getCell(6).getStringCellValue();
            String s3= row.getCell(7).getStringCellValue();
            String s4= row.getCell(8).getStringCellValue();
            String sql = "update damage set s1 = '"+s1+"',s2 = '"+s2+"' where s3 = '"+s3+"',s4 = '"+s4+"';";

            System.out.println(sql);

        }
        //关流
        sheets.close();
        stream.close();
    }
}
