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
             subject.setNumber(Integer.parseInt(number));//强转，因为int没有默认为0
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
					    // 数据回西显
				      	//1>项目主题的标题不能为空
						//2>项目的选项至少有2项
						//3>项目的开始投票时间默认为当前时间
						//4>项目的结束投票时间默认为1天以后
						//5>项目的发起人默认为登录用户
						//6>必须是网站的注册用户才可以发起项目，要写一个过滤器对/m.中进行判断是不是注册用户*/
			}catch (Exception e) {
				throw new RuntimeException(e);
			}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          this.doGet(request, response);

	}

}
