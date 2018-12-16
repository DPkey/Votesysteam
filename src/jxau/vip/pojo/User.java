package jxau.vip.pojo;
/*用户实体类
 * 
 * 提供get和set访问器
 * 
 * */
public class User {
     public static final int ONLINE = 2;
     public static final int NOTONLINE = 1;
	 public static final String SESSION_NAME ="CurrentUser";
	 private Integer id; //用int，默认会是0
     private String name;
     private String pwd;
     private String confirmPwd;

	public String getConfirmPwd() {
		return confirmPwd;
	}
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
	//1在线，2不在线
     private int online;
     
     
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getOnline() {
		return online;
	}
	public void setOnline(int online) {
		this.online = online;
	}
}
