package jxau.vip.until.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.enterprise.inject.New;



public class DbHelper {
	//��ȡ���Ӷ���
	private static ThreadLocal<Connection> conpool= new ThreadLocal<Connection>();
	
	public static Connection getConnection() 
			throws Exception{
		Connection con = conpool.get();
		if(con == null){
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/votedb?useSSL=false?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true","root","djs980410");
	     conpool.set(con);
		}
		return con;
	}
	//�ر�����ʱ�����̲߳����Ƴ�
	public static void close()throws Exception {
		Connection con = conpool.get();
		if(con!=null){
			con.close();
			conpool.remove();
		}
		
	}
	//�ͷ���Դ
	public static void closeAll(Connection con,
			PreparedStatement pst,ResultSet rs) throws Exception{
		if(rs!=null){
			rs.close();
		}
		if(pst!=null){
			pst.close();
		}
		if(con!=null){
			con.close();
		}
	}
	//������������������������ύ���ع���
	public static void beginTransaction() throws Exception{
		getConnection().setAutoCommit(false);
	}
	
	public static void commitTransaction() throws Exception{
		getConnection().commit();
	}
	
	public static void rollbackTransaction() throws Exception{
		getConnection().rollback();
	}
	
}