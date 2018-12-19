package jxau.vip.until.base;

import java.util.List;

import jxau.vip.until.base.BaseQueryModel;

/*���ݷ�����ĸ��ӿ�
 * ������ɾ�Ĳ�ķ���
 * 
 * */
public interface BaseDao {
	//Object Ӧ�����ϴ���ԭ��
	public int insert(Object data) throws Exception;
	//���ݶ���id���Զ���������Ϊ����
	//������������û��idֵ���޸�ʱ��������id
	public int updata(Object data) throws Exception;
	//����idɾ��
	public int delete(int id) throws Exception;
	public List findAll() throws Exception;
	//����id������һ������
	public Object findOne(int id) throws Exception;
	//�������������������������ļ�¼
	//�������������ݣ�һ��������ĳЩ���Ե�ֵ��ʵ����
	//UserQueryModel  SubjectQueryModel
	public List findByCondition(BaseQueryModel queryModel) throws Exception;
	
	public Long findId() throws Exception;
	
	//TODO ����д��ѯ����
	}

