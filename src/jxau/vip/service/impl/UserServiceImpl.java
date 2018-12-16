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
		//�û�������Ϊ��
		if(user.getName() == null || user.getName().trim().length() == 0){//trimȥ�ո�
			throw new RuleException("�û�������Ϊ��");//�����쳣������ʾ������Ϣ
		}
		if(user.getPwd() == null || user.getPwd().trim().length() == 0 ){
			throw new RuleException("���벻��Ϊ����");
		}
		//ȷ������������ͬ
		if(!user.getPwd().equals(user.getConfirmPwd())){
			throw new RuleException("�������ε����벻��ͬ");
		}
		UserQueryModel qm = new UserQueryModel();
		qm.setName(user.getName()); 
		System.out.println(qm.toString());
		List list =  userDao.findByCondition(qm);
		if(list.size()>0){
			throw new RuleException("�û����Ѿ���ע��");
		}
		user.setOnline(1);
		user.setPwd(Md5Class.stringToMd5(user.getPwd()));//�������
		
		userDao.insert(user);//ע��ɹ����û��������ݿ�
		
		
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
				throw new RuleException("�û��Ѿ�����");
				
			}
		}else{throw new RuleException("�˻������������");
			
		}
		return user;
	}
	public User getUser(int id) throws Exception{
		return (User)userDao.findOne(id);//ͨ����id�ķ������Զ�����������п��԰�������Ϣ����user
		
	}

}
