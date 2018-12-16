package jxau.vip.ui.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxau.vip.dao.impl.UserDaoImpl;
import jxau.vip.pojo.User;
import jxau.vip.service.UserService;
import jxau.vip.service.impl.UserServiceImpl;
import jxau.vip.until.exception.RuleException;

public class DoRegServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             /*1.获得提交的数据
              * 2.处理数据
              *3. 把处理结果返回给jsp页面
              * 
              */
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		String confirmPwd=request.getParameter("confirmPwd");
		
		//用实体对象装数据
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		user.setConfirmPwd(confirmPwd);
		
		try {
			UserService service = new UserServiceImpl();
			service.register(user);      //对获得的数据进行判断用户是否填写规范
			//跳转到登入页面
			response.sendRedirect(request.getContextPath()+"/pages/login.jsp");//!!!!!!!!!!!!!!!!!!!!!!!
			
		} catch (RuleException re) {//用户操作不当进行数据回西显
			// TODO: handle exceptionru
			request.setAttribute("user", user);
			request.setAttribute("message", re.getMessage());
			request.getRequestDispatcher("/reg.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           this.doGet(request, response);
           

	}

}
