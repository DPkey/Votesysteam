package jxau.vip.ui.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jxau.vip.pojo.Option;
import jxau.vip.pojo.Subject;
import jxau.vip.pojo.User;
import jxau.vip.service.SubjectService;
import jxau.vip.service.impl.SubjectServiceImpl;
import jxau.vip.until.exception.RuleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DoAddServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             String title = request.getParameter("title");
             String number = request.getParameter("number");
             String[] options=request.getParameterValues("options");
             
             Subject subject = new Subject();
             subject.setTitle(title);
             subject.setNumber(Integer.parseInt(number));//ǿת����Ϊintû��Ĭ��Ϊ0
             for(String content: options){
            	 Option option = new Option();
            	 option.setContent(content);
            	 
            	 subject.getOptions().add(option);
             }
             try {
            	 HttpSession session = request.getSession();
            	 SubjectService subjectService =new SubjectServiceImpl();
            	 subjectService.add(subject, (User)session.getAttribute(User.SESSION_NAME));
            	 
            	 response.sendRedirect(request.getContextPath()+"/pages/list.jsp");
					

				
			} catch (RuleException re) {
					    // ���ݻ�����
				      	//1>��Ŀ����ı��ⲻ��Ϊ��
						//2>��Ŀ��ѡ��������2��
						//3>��Ŀ�Ŀ�ʼͶƱʱ��Ĭ��Ϊ��ǰʱ��
						//4>��Ŀ�Ľ���ͶƱʱ��Ĭ��Ϊ1���Ժ�
						//5>��Ŀ�ķ�����Ĭ��Ϊ��¼�û�
						//6>��������վ��ע���û��ſ��Է�����Ŀ��Ҫдһ����������/m.�н����ж��ǲ���ע���û�*/
			}catch (Exception e) {
				throw new RuntimeException(e);
			}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          this.doGet(request, response);

	}

}
