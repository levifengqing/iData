package com.test.importdatas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
}
