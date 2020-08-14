package com.test.importdatas.getFile;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class GetFileName {


    public static void main(String[] args) {
        getFileName1();
    }
    public static void getFileName(){
        String path = "C:/Users/29097/Desktop/新建文件夹"; // 路径
        File f = new File(path);
        if (!f.exists()) {
            System.out.println(path + " not exists");
            return;
        }

        File fa[] = f.listFiles();
        for (int i = 0; i < fa.length; i++) {
            File fs = fa[i];
            if (fs.isDirectory()) {
                System.out.println(fs.getName() + " [目录]");
            } else {
                System.out.println(fs.getName());
            }
        }
    }


             public static void getFileName1(){

                     String path = "";
                     path = "E:/workspaces/guangdong/shenzhen/gdsz_yhgl";
                     File f = new File(path);
                     if (!f.exists()) {
                         System.out.println(path + " not exists");
                         return;
                     }
                 File fa[] = f.listFiles();
                 for (int i = 0; i < fa.length; i++) {
                     File fs = fa[i];
                     if (fs.isDirectory()) {
                         System.out.println(path+"---------"+fs.getName() + " [目录]");
                         String path1 = "/"+fs.getName();
                         String pathNew = "";
                         pathNew = path + path1;
                         File file = new File(pathNew);
                         File[] files = file.listFiles();
                         if(files!=null&&files.length>0){
                            getAllFiles(files,pathNew);
                         }
                     } else {
                         System.out.println(path+"-----"+fs.getName());
                     }
                 }
             }
             public static void getAllFiles(File[] fa,String path){
                 for (int i = 0; i < fa.length; i++) {
                     File fs = fa[i];
                     if (fs.isDirectory()) {
                         System.out.println(path+"---------"+ fs.getName() + " [目录]");
                         String path1 = "/"+fs.getName();
                         String pathNew = "";
                         pathNew = path + path1;
                         File file = new File(pathNew);
                         File[] files = file.listFiles();
                         if(files!=null&&files.length>0){
                             getAllFiles(files,pathNew);
                         }
                     } else {
                         System.out.println(path+"-----"+fs.getName());
                     }
                 }
             }


             public static void getAllFileName(File[] fa,String path){
                 for (int i = 0; i < fa.length; i++) {
                     File fs = fa[i];
                     if (fs.isDirectory()) {
                         System.out.println(fs.getName() + " [目录]");
                         File[] files = fs.listFiles();
                         getAllFileName(files,"");
                     } else {
//                         System.out.println(path+"-----"+fs.getName());
                         System.out.println("update attach set CCMC = '"+fs.getName()+"' where CCDZ = '"+path+"';");
                     }
                 }
             }
}
