package jxau.vip.ui.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import jxau.vip.until.filter.MyRequest;

public class EncodeFilter implements Filter {
	private String encode;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request =(HttpServletRequest) req;
		
		req.setCharacterEncoding(encode);
		req.setCharacterEncoding(encode);
		//get
		if("GET".equals(request.getMethod().toUpperCase())){
			MyRequest mr  = new MyRequest(request);
			mr.setEncode(this.encode);
			req=mr;
		}
		
		chain.doFilter(req,res);
		
	}

	@Override
	public void init(FilterConfig Config) throws ServletException {
		// TODO Auto-generated method stub
		encode = Config.getInitParameter("enc");//在配置中设置好了
	}

}
