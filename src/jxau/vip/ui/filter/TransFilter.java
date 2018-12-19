package jxau.vip.ui.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import jxau.vip.until.dao.DbHelper;

public class TransFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try{
			DbHelper.beginTransaction();
			
			chain.doFilter(request, response);
			
			DbHelper.commitTransaction();
			
			DbHelper.close();
		}catch (Exception e) {
			
			try {
				DbHelper.rollbackTransaction();
				DbHelper.close();
				
			} catch (Exception e2) {
				throw new RuntimeException(e2);
			}
			throw new RuntimeException(e);
		}
		

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
