package cn.xportal.web.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BaseIntercepter extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(BaseIntercepter.class);

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("do {} on {}", "afterCompletion", request);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("do {} on {}", "afterConcurrentHandlingStarted", request);
	}

	@Override
	public void postHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler,
			ModelAndView modelAndView)
			throws Exception {
		logger.info("do {} on {}", "postHandle", request);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("do {} on {}", "preHandle", request);
		return true;
	}

}
