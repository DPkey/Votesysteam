package jxau.vip.ui.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxau.vip.dao.impl.UserDaoImpl;
import jxau.vip.pojo.User;
import jxau.vip.service.UserService;
import jxau.vip.service.impl.UserServiceImpl;
import jxau.vip.until.exception.RuleException;

public class DoLoginServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             String name =request.getParameter("name");
             String pwd =request.getParameter("pwd");
             String remember = request.getParameter("remember");
             User user = new User();
             user.setName(name);
             user.setPwd(pwd);
             
             try {
            	UserService userService =new UserServiceImpl();
            	user = userService.login(user);
            	
            	HttpSession session = request.getSession();
            	session.setAttribute(User.SESSION_NAME, user);
            	if(remember != null){
            		Cookie cookie = new Cookie(user.SESSION_NAME, user.getId().toString());
            		cookie.setMaxAge(10*24*60*60);
            		response.addCookie(cookie);
            	}
            	response.sendRedirect(request.getContextPath()+"/list");
            	
				
			} catch (RuleException re) {
				request.setAttribute("user", user);
				request.setAttribute("message", re.getMessage());
				// TODO: handle exception
			}catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException(e);
			}

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                this.doGet(request, response);

	}

}
