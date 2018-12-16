package votsyste;


import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import jxau.vip.dao.impl.UserDaoImpl;
import jxau.vip.pojo.User;
import jxau.vip.pojo.UserQueryModel;
import jxau.vip.until.base.BaseDaoImpl;
		
	public class TestUserDaoImpl {
		@Test
		public void testInsert() throws Exception{
			// ����Ŀ����Ķ��󣬵���Ŀ�귽�����õ�ʵ�����еĽ��
			UserDaoImpl userDao = new UserDaoImpl();
			
			User user = new User();
			user.setName("Rose");
			user.setPwd("123456");
			user.setOnline(1);
			
			int actual = userDao.insert(user);
			
			
			// д���� Ԥ�ƵĽ��
			int expected=1;
			// ʹ�ö�����Ƚ�Ԥ�ƵĽ����ʵ�����еĽ��
			Assert.assertEquals(expected, actual);
		}
		@Test
		public void testFindAll()throws Exception{
			UserDaoImpl userdao = new UserDaoImpl();
			List actual = userdao.findAll();
			int expected=3;
			Assert.assertEquals(expected, actual.size());
			
		}
		@Test
		public void testFindByCondition() throws Exception{
			UserDaoImpl userDao = new UserDaoImpl();
			UserQueryModel qm = new UserQueryModel();
			qm.setName("Rose");
			qm.setOnline(1);
			List list = userDao.findByCondition(qm);
			
			int expected=3;
			Assert.assertEquals(expected, list.size());
		} 
		@Test
		public void testUpdate() throws Exception{
			// ����Ŀ�������
			BaseDaoImpl baseDao = new UserDaoImpl();
			// ����Ŀ�귽�����õ�ʵ�����еĽ��
			User user = new User();
			user.setId(1);
			user.setName("Rose");
			user.setPwd("666");
			user.setOnline(1);
			
			int actual = baseDao.updata(user);
			// д����Ԥ�ƵĽ��(�˹����ݹ��ܼ���)
			int expected=1;
			// ���������Ƚ�ʵ�����еĽ����Ԥ�ƵĽ��
			Assert.assertEquals(expected, actual);
		}
		@Test
		public void delete(int id) throws Exception {
			BaseDaoImpl baseDao = new UserDaoImpl();
			id = 3;
			int actual = baseDao.delete(id);
			int expected = 1;
			Assert.assertEquals(expected, actual);
			
			
			
		}
	}
