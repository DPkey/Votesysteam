package jxau.vip.until.base;

import java.util.List;

import jxau.vip.until.base.BaseQueryModel;

/*数据访问类的父接口
 * 声明增删改查的方法
 * 
 * */
public interface BaseDao {
	//Object 应用里氏代换原则
	public int insert(Object data) throws Exception;
	//数据都有id，自动增长，作为主键
	//新增的数据中没有id值，修改时，必须有id
	public int updata(Object data) throws Exception;
	//按照id删除
	public int delete(int id) throws Exception;
	public List findAll() throws Exception;
	//根据id主键查一个对象
	public Object findOne(int id) throws Exception;
	//按照条件来查所有满足条件的记录
	//构造条件的数据：一般是属于某些属性的值；实体类
	//UserQueryModel  SubjectQueryModel
	public List findByCondition(BaseQueryModel queryModel) throws Exception;
	
	public Long findId() throws Exception;
	
	//TODO ：编写查询方法
	}

