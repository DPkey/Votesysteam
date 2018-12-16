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
             /*1.����ύ������
              * 2.��������
              *3. �Ѵ��������ظ�jspҳ��
              * 
              */
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		String confirmPwd=request.getParameter("confirmPwd");
		
		//��ʵ�����װ����
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		user.setConfirmPwd(confirmPwd);
		
		try {
			UserService service = new UserServiceImpl();
			service.register(user);      //�Ի�õ����ݽ����ж��û��Ƿ���д�淶
			//��ת������ҳ��
			response.sendRedirect(request.getContextPath()+"/pages/login.jsp");//!!!!!!!!!!!!!!!!!!!!!!!
			
		} catch (RuleException re) {//�û����������������ݻ�����
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
