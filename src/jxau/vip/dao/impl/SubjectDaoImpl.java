package jxau.vip.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import jxau.vip.dao.SubjectDao;
import jxau.vip.until.base.BaseDaoImpl;
import jxau.vip.until.base.BaseQueryModel;
import jxau.vip.pojo.Subject;

public class SubjectDaoImpl extends BaseDaoImpl implements SubjectDao {


	@Override
	public String getInsertSql(Object data) {
        Subject subject = (Subject)data;
		
		return "insert into t_subject(title,number,startTime,endTime,userId) values('"+subject.getTitle()+"',"+subject.getNumber()+","+subject.getStartTime()+","+subject.getEndTime()+","+subject.getUser().getId()+")";
	}

	@Override
	public String getFindAllSql() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object rsToObject(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFindConditionSql(BaseQueryModel queryModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUpdateSql(Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDeleteSql(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
