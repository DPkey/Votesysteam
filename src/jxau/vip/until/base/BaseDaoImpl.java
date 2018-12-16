package jxau.vip.until.base;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;

import jxau.vip.until.dao.DbHelper;
import jxau.vip.until.base.BaseQueryModel;

/*
 *���ݷ��ʵĸ��࣬ʵ����ɾ�Ĳ�ķ��� 
 * */
public abstract class BaseDaoImpl implements BaseDao {
	@Override
	public int insert(Object data) throws Exception {
		//JDBC
		//1 �������ݿ����Ӷ���Connection
		Connection con = DbHelper.getConnection();
		//2 ��дsql��䣬�����������PreparedStatement
		String sql = getInsertSql(data);
		PreparedStatement pst = con.prepareStatement(sql);
		
		//3 ִ�����executeUpdate ,executeQuery
		int rows  = pst.executeUpdate();
		//4 ����ִ�еĽ����ResultSet�����
		//   ������еļ�¼ת����ʵ�������
		//5 �ͷ���Դ(�ر�����)
		DbHelper.closeAll(con, pst, null);
		return rows;
	}
	public List findAll() throws Exception{
		Connection con=DbHelper.getConnection();
		String sql= getFindAllSql();
		PreparedStatement pst=con.prepareStatement(sql);
		ResultSet rs =pst.executeQuery();
		List list = new ArrayList();
		while(rs.next()){
			Object data = rsToObject(rs);
			list.add(data);
		}
		DbHelper.closeAll(con, pst, rs);
		return list;
		
	}
	public Object findOne(int id) throws Exception {
		Connection con=DbHelper.getConnection();
		String sql=getFindAllSql()+"where id ="+id;
		PreparedStatement pst=con.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		Object result=null;
		if(rs.next()){
			result = rsToObject(rs);
		}
		DbHelper.closeAll(con, pst, rs);
		
		return result;
	}
	public List findByCondition(BaseQueryModel queryModel) throws Exception {
		// 1 �������ݿ����Ӷ���Connection
		Connection con = DbHelper.getConnection();
		// 2 ��дsql��䣬�����������PreparedStatement
		String sql = getFindConditionSql(queryModel);
		PreparedStatement pst = con.prepareStatement(sql);

		// 3 ִ�����executeUpdate ,executeQuery
		ResultSet rs = pst.executeQuery();
		// 4 ����ִ�еĽ����ResultSet�����
		// ������еļ�¼ת����ʵ�������
		List list = new ArrayList();
		while (rs.next()) {
			// ��һ����¼ת����java����
			Object data = rsToObject(rs);
			// ��������뵽������
			list.add(data);
		}

		// 5 �ͷ���Դ(�ر�����)
		DbHelper.closeAll(con, pst, rs);

		return list;
	}
	
	@Override
	public int updata(Object data) throws Exception {
		// 1 �������ݿ����Ӷ���Connection
				Connection con = DbHelper.getConnection();
				// 2 ��дsql��䣬�����������PreparedStatement
				String sql = getUpdateSql(data);
				PreparedStatement pst = con.prepareStatement(sql);

				// 3 ִ�����executeUpdate ,executeQuery
				int rows = pst.executeUpdate();

				// 4 ����ִ�еĽ����ResultSet�����
				// ������еļ�¼ת����ʵ�������
				// 5 �ͷ���Դ(�ر�����)
				DbHelper.closeAll(con, pst, null);
				return rows;
    
	}

	@Override
	public int delete(int id) throws Exception {
		// 1 �������ݿ����Ӷ���Connection
		Connection con = DbHelper.getConnection();
		// 2 ��дsql��䣬�����������PreparedStatement
		String sql = getDeleteSql(id);
		PreparedStatement pst = con.prepareStatement(sql);

		// 3 ִ�����executeUpdate ,executeQuery
		int rows = pst.executeUpdate();

		// 4 ����ִ�еĽ����ResultSet�����
		// ������еļ�¼ת����ʵ�������
		// 5 �ͷ���Դ(�ر�����)
		DbHelper.closeAll(con, pst, null);
		return rows;
	}
	public abstract String getInsertSql(Object data);
	public abstract String getFindAllSql();
	public abstract Object rsToObject(ResultSet rs) throws Exception;
	public abstract String getFindConditionSql(BaseQueryModel queryModel);
	public abstract String getUpdateSql(Object data);
	public abstract String getDeleteSql(int id);

}
