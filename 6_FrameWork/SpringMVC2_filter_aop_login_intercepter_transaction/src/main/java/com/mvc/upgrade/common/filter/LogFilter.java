package com.mvc.upgrade.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Filter : DispatcherServelt 앞단에서 정보처리.
//Log : 기록을 남기는 것을 의미.
public class LogFilter implements Filter {
	//init() : 필터 인스턴스 초기화
	//doFilter() : 전/후처리
	//destroy() : 필터 인스턴스 종료
	
	//로거 객체를 생성
	private Logger logger = LoggerFactory.getLogger(LogFilter.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		String remoteAddr = req.getRemoteAddr()+"\n";	// ip주소
		String uri = req.getRequestURI()+"\n";
		String url = req.getRequestURL()+"\n";
		String queryString = req.getQueryString()+"\n";
		
		String referer = req.getHeader("referer")+"\n";
		
		String str = remoteAddr+uri+url+queryString+referer;
		
		logger.info("LOG FILTER\n"+str+"\n");
		
		chain.doFilter(req, response);
		//해당 필터의 처리결과를 다음으로 넘겨주는 역할.
		//만약 다음 필터가 있다면 다음필터로, 없다면 서블릿으로.
	}

	@Override
	public void destroy() {
		
	}
	
	
	
}
