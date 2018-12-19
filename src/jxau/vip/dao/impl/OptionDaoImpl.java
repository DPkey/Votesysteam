package jxau.vip.dao.impl;

import java.sql.ResultSet;

import jxau.vip.pojo.Option;

import jxau.vip.dao.OptionDao;
import jxau.vip.until.base.BaseDaoImpl;
import jxau.vip.until.base.BaseQueryModel;

public class OptionDaoImpl extends BaseDaoImpl implements OptionDao{

	@Override
	public String getInsertSql(Object data) {
		Option option =(Option)data;
		return "insert into t_option(content,idx,subjectId) values('"+option.getContent()+"',"+option.getIdx()+","+option.getSubjectId()+")";
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