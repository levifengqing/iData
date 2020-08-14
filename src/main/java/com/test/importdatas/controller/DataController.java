package com.test.importdatas.controller;

import com.microsoft.schemas.office.visio.x2012.main.CellType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("data")
public class DataController {
    @GetMapping("login")
    public String login(){
        return "iData";
    }
    @PostMapping("uploadPic")
    @ResponseBody
    public Map uploadPic(@RequestParam MultipartFile file, HttpServletRequest request){
        //保存上传
        OutputStream out;
        out = null;
        InputStream fileInput=null;
        try{
            if(file!=null){
                String name = file.getName();
                String originalFilename = file.getOriginalFilename();
                System.out.println(name+"==="+originalFilename);
                String filepath = request.getServletContext().getRealPath("/")+"file\\images\\"+originalFilename;
                File files=new File(filepath);
                //打印查看上传路径
                System.out.println("filepath:"+filepath);
                if(!files.getParentFile().exists()){
                    files.getParentFile().mkdirs();
                }
                file.transferTo(files);
                Map<String,Object> map=new HashMap<>();
                map.put("code",0);
                map.put("msg","");
                map.put("src",filepath);
                return map;
            }

        }catch (Exception e){
        }finally{
            try {
                if(out!=null){
                    out.close();
                }
                if(fileInput!=null){
                    fileInput.close();
                }
            } catch (IOException e) {
            }
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",1);
        map.put("msg","");
        return map;
    }

    @PostMapping("uploadFile")
    @ResponseBody
    public Map uploadFile(@RequestParam MultipartFile file, HttpServletRequest request){
        //保存上传
        OutputStream out;
        out = null;
        InputStream fileInput=null;
        try{
            if(file!=null){
                String name = file.getName();
                String originalFilename = file.getOriginalFilename();
                System.out.println(name+"==="+originalFilename);
                String filepath = request.getServletContext().getRealPath("/")+"file\\excel\\"+originalFilename;
                File files=new File(filepath);
                //打印查看上传路径
                System.out.println("filepath:"+filepath);
                if(!files.getParentFile().exists()){
                    files.getParentFile().mkdirs();
                }
                file.transferTo(files);
                Map<String,Object> map=new HashMap<>();
                map.put("code",0);
                map.put("msg","");
                map.put("src",filepath);
                return map;
            }

        }catch (Exception e){
        }finally{
            try {
                if(out!=null){
                    out.close();
                }
                if(fileInput!=null){
                    fileInput.close();
                }
            } catch (IOException e) {
            }
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",1);
        map.put("msg","");
        return map;
    }

    @PostMapping("uploadFile_write")
    @ResponseBody
    public Map uploadFile_write(@RequestParam MultipartFile file, HttpServletRequest request){
        //保存上传
        OutputStream out;
        out = null;
        InputStream fileInput=null;
        try{
            if(file!=null){

//                File file1 = new File("C:\\Users\\29097\\Desktop\\task\\4.xlsx");
//                FileCopyUtils.copy(file.getBytes(),file1);

                XSSFWorkbook sheets = new XSSFWorkbook(file.getInputStream());
//                XSSFWorkbook sheets = new XSSFWorkbook("C:\\Users\\29097\\Desktop\\task\\4.xlsx");

                //获取一个工作表(sheet页)，下标从0开始
                Sheet sheet = sheets.getSheetAt(0);
                for (int i = 1; i<=sheet.getLastRowNum() ; i++) {
                    // 获取行数
                    Row row = sheet.getRow(i);
                    row.createCell(1);
                    row.createCell(2);
                    row.createCell(3);
                    row.createCell(4);
//                    row.getCell(1).setCellType(CellType.STRING);  //poi3.17
//                    row.getCell(2).setCellType(CellType.STRING);  //poi3.17
//                    row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);  //poi3.14
//                    row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);  //poi3.14
                    String s1 = row.getCell(1).getStringCellValue();
                    String s2 = row.getCell(2).getStringCellValue();
                    String s3= row.getCell(3).getStringCellValue();
                    String s4= row.getCell(4).getStringCellValue();
                    String sql = "update damage set s1 = '"+s1+"',s2 = '"+s2+"' where s3 = '"+s3+"',s4 = '"+s4+"';";

                    System.out.println(sql);

                }
                //关流
                sheets.close();
//                Stream.close();
                Map<String,Object> map=new HashMap<>();
                map.put("code",0);
                map.put("msg","");
                return map;
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(out!=null){
                    out.close();
                }
                if(fileInput!=null){
                    fileInput.close();
                }
            } catch (IOException e) {
            }
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",1);
        map.put("msg","");
        return map;
    }


}
