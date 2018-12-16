package jxau.vip.ui.filter;

import java.io.IOException;

import javax.management.RuntimeErrorException;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxau.vip.pojo.User;
import jxau.vip.service.UserService;
import jxau.vip.service.impl.UserServiceImpl;

public class AutoLoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
	   HttpSession session = request.getSession();
	   if(session.getAttribute(User.SESSION_NAME) ==null){//判断是否已经登陆，没有值说明没有登陆，如果登入就不需要自动登陆
		   Cookie[] cookies = request.getCookies();
		    if(cookies!= null){
		    	for(Cookie cookie : cookies){
		    		if(User.SESSION_NAME.equals(cookie.getName())){
		    			int id = Integer.parseInt(cookie.getValue());
		    			
		    			UserService userService = new UserServiceImpl();
		    			try {
							User user= userService.getUser(id);
							session.setAttribute(user.SESSION_NAME, user);
						} catch (Exception e) {
							throw new RuntimeException();
						}
		    		}
		    	}
		    	chain.doFilter(request, response);
		    }
		    
		   
	   }
		
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
