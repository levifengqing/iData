package com.test.importdatas.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.importdatas.controller.BaseFrontController;
import com.test.importdatas.dao.UserDao;
import com.test.importdatas.pojo.User;
import com.test.importdatas.util.ExcelFormatUtil;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ExportServiceImpl implements ExportService{
	Logger logger = LoggerFactory.getLogger(ExportServiceImpl.class);
	@Autowired
	private UserDao userDao;

	@Override
	public ResponseEntity<byte[]> exportExcel(HttpServletRequest request, HttpServletResponse response) {
		try {
			logger.info(">>>>>>>>>>开始导出excel>>>>>>>>>>");
//			List<User> list = userDao.findAll();
			// 造几条数据
			List<User> list = new ArrayList<>();
			list.add(new User("唐三藏", "男", 30, "13411111111", "东土大唐", "取西经"));
			list.add(new User("孙悟空", "男", 29, "13411111112", "菩提院", "打妖怪"));
			list.add(new User("猪八戒", "男", 28, "13411111113", "高老庄", "偷懒"));
			list.add(new User("沙悟净", "男", 27, "13411111114", "流沙河", "挑担子"));
			
			BaseFrontController baseFrontController = new BaseFrontController();
			return baseFrontController.buildResponseEntity(export((List<User>) list,response), "用户表.xls");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(">>>>>>>>>>导出excel 异常，原因为：" + e.getMessage());
		}
		return null;
	}

	private InputStream export(List<User> list,HttpServletResponse response) {
		logger.info(">>>>>>>>>>>>>>>>>>>>开始进入导出方法>>>>>>>>>>");
		ByteArrayOutputStream output = null;
		InputStream inputStream1 = null;
		SXSSFWorkbook wb = new SXSSFWorkbook(1000);// 保留1000条数据在内存中
		SXSSFSheet sheet = wb.createSheet();
		// 设置报表头样式
		CellStyle header = ExcelFormatUtil.headSytle(wb);// cell样式
		CellStyle content = ExcelFormatUtil.contentStyle(wb);// 报表体样式
		
		// 每一列字段名
		String[] strs = new String[] { "姓名", "性别", "年龄", "手机号", "地址","爱好" };
		
		// 字段名所在表格的宽度
		int[] ints = new int[] { 5000, 5000, 5000, 5000, 5000, 5000 };
		
		// 设置表头样式
		ExcelFormatUtil.initTitleEX(sheet, header, strs, ints);
		logger.info(">>>>>>>>>>>>>>>>>>>>表头样式设置完成>>>>>>>>>>");
		
		if (list != null && list.size() > 0) {
			logger.info(">>>>>>>>>>>>>>>>>>>>开始遍历数据组装单元格内容>>>>>>>>>>");
			for (int i = 0; i < list.size(); i++) {
				User user = list.get(i);
				SXSSFRow row = sheet.createRow(i + 1);
				int j = 0;

				SXSSFCell cell = row.createCell(j++);
				cell.setCellValue(user.getName()); // 姓名
				cell.setCellStyle(content);

				cell = row.createCell(j++);
				cell.setCellValue(user.getSex()); // 性别
				cell.setCellStyle(content);

				cell = row.createCell(j++);
				cell.setCellValue(user.getAge()); // 年龄
				cell.setCellStyle(content);

				cell = row.createCell(j++);
				cell.setCellValue(user.getPhoneNo()); // 手机号
				cell.setCellStyle(content);

				cell = row.createCell(j++);
				cell.setCellValue(user.getAddress()); // 地址
				cell.setCellStyle(content);
				
				cell = row.createCell(j++);
				cell.setCellValue(user.getHobby()); // 爱好
				cell.setCellStyle(content);
			}
			logger.info(">>>>>>>>>>>>>>>>>>>>结束遍历数据组装单元格内容>>>>>>>>>>");
		}
		try {
			//直接将数据输出到response的输出流，页面直接下载
			/*String fileName = "绿化土壤湿度监测表";
			OutputStream ouputStream = response.getOutputStream();
			response.setHeader("Set-Cookie", "fileDownload=true; path=/");
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes(), "iso-8859-1") + ".xlsx");
			wb.write(ouputStream);*/
			//wb.write(),只能使用一次，使用一次后，会关闭stream。
			output = new ByteArrayOutputStream();
			wb.write(output);
			inputStream1 = new ByteArrayInputStream(output.toByteArray());
			output.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (output != null) {
					output.close();
					if (inputStream1 != null)
						inputStream1.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return inputStream1;
	}
}
