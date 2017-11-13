package com.finra.codingchallenge.interceptor;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author Abhinav Akey
 * @since 1.0
 */
public class LoggingInterceptor extends HandlerInterceptorAdapter {

	private static final Logger LOG = LoggerFactory.getLogger(LoggingInterceptor.class);

	private static final String INTERCEPTOR_LOG_START = "{} request to the session interceptor execution start on {} {}.",
			INTERCEPTOR_LOG_END = "The session interceptor execution finished on {} {}, {}.";

	@PostConstruct
	public void init() {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws ServletException, IOException {
		final String requestMethod = request.getMethod(), servletPath = request.getRequestURI();
		LOG.debug(INTERCEPTOR_LOG_START, "Incoming", requestMethod, servletPath);		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		final String requestMethod = request.getMethod(), servletPath = request.getRequestURI();
		LOG.debug(INTERCEPTOR_LOG_END, "Exiting", requestMethod, servletPath);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		final String requestMethod = request.getMethod(), servletPath = request.getRequestURI();
		LOG.debug(INTERCEPTOR_LOG_START, "After Completion", requestMethod, servletPath);
		super.afterCompletion(request, response, handler, ex);
		LOG.debug(INTERCEPTOR_LOG_END, "After Completion", requestMethod, servletPath);
	}
}