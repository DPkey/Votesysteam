package jxau.vip.pojo;

import java.util.ArrayList;
import java.util.List;

import jxau.vip.pojo.Option;

public class Subject {
	public static int SINGLE=1;
	public static int MULTI=2;
	
	private Long id;
	private String title;
	private Integer number;
	private Long startTime;
	private Long endTime;
	
	private User user;
	
	private List<Option>options;
	
	
	//视图属性
	private String startTimeView;
	private String endTimeView;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Option> getOptions() {
		return options;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
	}
	
	
	public Subject() {
		super();
		//将集合属性进行实例化
		this.options=new ArrayList<Option>();
	}
	
	
	public String getStartTimeView() {
		return startTimeView;
	}

	public String getEndTimeView() {
		return endTimeView;
	}



}
