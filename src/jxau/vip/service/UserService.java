package jxau.vip.service;

import jxau.vip.pojo.User;

public interface UserService {
	public void register(User user)throws Exception;
	public User login(User user)throws Exception;
	public User getUser(int id)throws Exception;
		
	}



