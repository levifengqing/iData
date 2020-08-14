package com.test.importdatas.config;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
 
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
 
import static com.test.importdatas.config.ConstantConfig.TRACE_ID;

/**
 * Created by yanshao on 2019-10-09.
 */
public class WebTraceFilter implements Filter {
 
    private static final Logger log = LoggerFactory.getLogger(WebTraceFilter.class);
 
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (! (servletRequest instanceof HttpServletRequest) || ! (servletResponse instanceof HttpServletResponse)) {
            throw new ServletException("只支持http请求");
        }
        try {
            MDC.put(TRACE_ID, UUID.randomUUID().toString().replace("-",""));
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            MDC.remove(TRACE_ID);
        }
    }
}