package com.mvc.upgrade.common.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


//_interceptor : Dispatcher Servlet 과 controller 사이에서 활동

public class LoginInterceptor implements HandlerInterceptor {
		private Logger logger=LoggerFactory.getLogger(LoginInterceptor.class);
	
		// controller 실행 요청 전에 수행되는 메소드
		// return 값으로 boolean 값을 전달 , false인 경우 controller 실행 시키지 않고 종료
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
			logger.info("interceptor : preHandle");
			// 로그인이 되어 있는 상태에서만 작동
			
			if(request.getSession().getAttribute("login") != null || 
				request.getRequestURI().contains("/loginform.do") ||
				request.getRequestURI().contains("/ajaxlogin.do")) {
				return true;
				/*
				로그인이 되어있는 상태이거나 
				request.getRequestURI().contains("/loginform.do") > 로그인을 하기위해 화면으로 넘어가는 요청이거나 
				request.getRequestURI().contains("/ajaxlogin.do") > 아이디와 비밀번호를 들고 로그인을 하려는 요청일때
				controller 실행 O
				*/
			}
			
			if(request.getSession().getAttribute("login") == null) {
				response.sendRedirect("loginform.do"); // 로그인이 되어있지 않으니 (리스트에 갈 수 없으니) 로그인을 하게끔 sendRedirect를 사용하여 페이지 이동
				// sendRedirect로 Dispatcher로 이동했다가 HadlerMapping을 지나 다시 controller로 넘어옴
				return false;
				// controller 실행 X
			}
			return false;
		}
		
		
		// view > forward되기 전에 수행, controller에서 에러 발생 시 해당 메소드는 수행되지 않는다.
		@Override
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) {
			logger.info("interceptor : postHandle");
		}
		
		
		// view 까지 처리가 다 끝난후 수행
		@Override
		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
			logger.info("interceptor : afterCompletion");
		}
}
