package jxau.vip.dao.impl;


import java.sql.ResultSet;
import jxau.vip.dao.UserDao;
import jxau.vip.until.base.BaseDaoImpl;
import jxau.vip.until.base.BaseQueryModel;
import jxau.vip.pojo.User;
import jxau.vip.pojo.UserQueryModel;


public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@Override
	public String getInsertSql(Object data) {
		// 返回新增用户的sql语句
		User user = (User) data;
		System.out.println("insert into t_user(name,pwd,online) " + " values('" + user.getName() + "','" + user.getPwd() + "',"
				+ user.getOnline() + ")");
		return "insert into t_user(name,pwd,online) " + " values('" + user.getName() + "','" + user.getPwd() + "',"
				+ user.getOnline() + ")";
	}
	public Object rsToObject(ResultSet rs) throws Exception  {
		User user =new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setPwd(rs.getString("pwd"));
		user.setOnline(rs.getInt("online"));
		
		return user;
		
	}
	@Override
	public String getFindAllSql() {
		return "select * from t_user";
	}
	public String getFindConditionSql(BaseQueryModel queryModel) {
		//向下转型
		UserQueryModel qm = (UserQueryModel)queryModel;
		StringBuilder sb=new StringBuilder();
		sb.append("select * from t_user");
		sb.append(" where 1=1 ");
		if(qm.getName()!=null && qm.getName().trim().length()>0){
			sb.append(" and name='"+qm.getName()+"'");
		}
		if(qm.getPwd()!=null && qm.getPwd().trim().length()>0){
			sb.append(" and pwd='"+qm.getPwd()+"'");
		}
		if(qm.getOnline()>0){
			sb.append("and online="+qm.getOnline());
		}
		System.out.println("!!!!!!!!!!!!"+sb.toString());
		return sb.toString();
	}
	@Override
	public String getUpdateSql(Object data) {
		// TODO Auto-generated method stub
		User user = (User)data;
		return "update t_user set name='"+user.getName()+"',pwd='"+user.getPwd()+"',"+
	    "online="+user.getOnline()+" where id=" + user.getId();
	}
	@Override
	public String getDeleteSql(int id) {
		// TODO Auto-generated method stub
		return "delete from t_user where id="+id;
	}

}
