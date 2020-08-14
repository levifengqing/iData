package com.test.importdatas.service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
public interface ExportService {
	ResponseEntity<byte[]> exportExcel(HttpServletRequest request, HttpServletResponse response);
}
