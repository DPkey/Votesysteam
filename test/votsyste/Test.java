package votsyste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import jxau.vip.dao.impl.UserDaoImpl;
import jxau.vip.pojo.User;
import jxau.vip.pojo.UserQueryModel;
import jxau.vip.until.dao.DbHelper;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 创建目标类的对象，调用目标方法，得到实际运行的结果
		Connection connection = DbHelper.getConnection();
		String sql="select *  from t_user";
		PreparedStatement pr = connection.prepareStatement(sql);
		ResultSet executeQuery = pr.executeQuery();
		if(executeQuery.next()){
			
			System.out.println(executeQuery.getString("name"));
		}
	     
		
		
					UserDaoImpl userDao = new UserDaoImpl();
					UserQueryModel qm = new UserQueryModel();
					qm.setName("gfh");
					
					System.out.println(qm.toString());
					//System.out.println();
					List<User> list =  userDao.findByCondition(qm);
					
					System.out.println(list.size());
					
//					User user = new User();
//					user.setName("Rose");
//					user.setPwd("123456");
//					user.setOnline(1);
					
//					 userDao.insert(user);
	}

}
