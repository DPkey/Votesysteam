package jxau.vip.service.impl;

import java.util.Date;

import jxau.vip.dao.OptionDao;
import jxau.vip.dao.SubjectDao;
import jxau.vip.dao.impl.OptionDaoImpl;
import jxau.vip.dao.impl.SubjectDaoImpl;
import jxau.vip.pojo.Subject;
import jxau.vip.pojo.Option;
import jxau.vip.pojo.User;
import jxau.vip.service.SubjectService;

public class SubjectServiceImpl implements SubjectService {
	private SubjectDao subjectDao;
	private OptionDao optionDao;
    public SubjectServiceImpl() {
		subjectDao=new SubjectDaoImpl();
		optionDao=new OptionDaoImpl();
	}
	

	@Override
	public void add(Subject subject, User user) throws Exception {
		// TODO Auto-generated method stub
		
		Long now =new Date().getTime();
		subject.setStartTime(now);
		subject.setEndTime(now+1*24*60*60*1000);
		subject.setUser(user);
		subjectDao.insert(subject);
		//新增主题的id
		Long sid= subjectDao.findId();
		int i =1;
		for(Option option :subject.getOptions()){
			option.setIdx(i++);
			
			optionDao.insert(option);
		}
		

	}

}
