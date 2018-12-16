package jxau.vip.service.impl;

import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;

import jxau.vip.dao.UserDao;
import jxau.vip.dao.impl.UserDaoImpl;
import jxau.vip.pojo.User;
import jxau.vip.pojo.UserQueryModel;
import jxau.vip.service.UserService;
import jxau.vip.until.base.BaseDaoImpl;
import jxau.vip.until.base.BaseQueryModel;
import jxau.vip.until.exception.RuleException;
import jxau.vip.until.format.Md5Class;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	public UserServiceImpl(){
		userDao = new UserDaoImpl();
	}

	@Override
	public void register(User user) throws Exception {
		//用户名不能为空
		if(user.getName() == null || user.getName().trim().length() == 0){//trim去空格
			throw new RuleException("用户名不能为空");//调用异常方法显示错误信息
		}
		if(user.getPwd() == null || user.getPwd().trim().length() == 0 ){
			throw new RuleException("密码不能为空且");
		}
		//确认两次密码相同
		if(!user.getPwd().equals(user.getConfirmPwd())){
			throw new RuleException("输入两次的密码不相同");
		}
		UserQueryModel qm = new UserQueryModel();
		qm.setName(user.getName()); 
		System.out.println(qm.toString());
		List list =  userDao.findByCondition(qm);
		if(list.size()>0){
			throw new RuleException("用户名已经被注册");
		}
		user.setOnline(1);
		user.setPwd(Md5Class.stringToMd5(user.getPwd()));//密码加密
		
		userDao.insert(user);//注册成功的用户加入数据库
		
		
	}

	@Override
	public User login(User user) throws Exception {
		// TODO Auto-generated method stub
		UserQueryModel qm=new UserQueryModel();
		qm.setName(user.getName());
		qm.setPwd(Md5Class.stringToMd5(user.getPwd()));
		List list =  userDao.findByCondition(qm);
		if(list.size()==1){
			user = (User)list.get(0);
			if(user.getOnline() == User.ONLINE){
				throw new RuleException("用户已经在线");
				
			}
		}else{throw new RuleException("账户名或密码错误");
			
		}
		return user;
	}
	public User getUser(int id) throws Exception{
		return (User)userDao.findOne(id);//通过找id的方法在自动登入过滤器中可以把所以信息放在user
		
	}

}
