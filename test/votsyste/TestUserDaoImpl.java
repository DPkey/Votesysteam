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
			// 创建目标类的对象，调用目标方法，得到实际运行的结果
			UserDaoImpl userDao = new UserDaoImpl();
			
			User user = new User();
			user.setName("Rose");
			user.setPwd("123456");
			user.setOnline(1);
			
			int actual = userDao.insert(user);
			
			
			// 写下来 预计的结果
			int expected=1;
			// 使用断言类比较预计的结果和实际运行的结果
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
			// 创建目标类对象
			BaseDaoImpl baseDao = new UserDaoImpl();
			// 调用目标方法，得到实际运行的结果
			User user = new User();
			user.setId(1);
			user.setName("Rose");
			user.setPwd("666");
			user.setOnline(1);
			
			int actual = baseDao.updata(user);
			// 写下来预计的结果(人工根据功能计算)
			int expected=1;
			// 断言类来比较实际运行的结果和预计的结果
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
