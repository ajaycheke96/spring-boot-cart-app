package com.dtech.api.tenant.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Configuration
public class MethodTestUtils implements HandlerInterceptor {

	private static final Logger log = LoggerFactory.getLogger(MethodTestUtils.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long currentTimeMillis = System.currentTimeMillis();
		request.setAttribute("startTime", currentTimeMillis);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String queryString=request.getQueryString()==null ? "" : "?"+request.getQueryString();
		String path= request.getRequestURL()+queryString;
		
		// start time
		long startTime = (long) request.getAttribute("startTime");
		
		// endTime 
		long endTime = System.currentTimeMillis();
		
		log.info(String.format("%s millisecond taken to process the request %s", (endTime-startTime), path));
	}
}
