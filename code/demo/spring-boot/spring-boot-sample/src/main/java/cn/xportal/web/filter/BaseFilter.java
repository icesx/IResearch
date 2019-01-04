package cn.xportal.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(urlPatterns = "/*", filterName = "baseFilter")
public class BaseFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(BaseFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException,
			ServletException {
		logger.info("doFilter on {}", request);
		chain.doFilter(request, response);
	}

}
