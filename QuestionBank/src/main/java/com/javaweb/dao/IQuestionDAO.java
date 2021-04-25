package com.javaweb.dao;

import com.javaweb.vo.AutoBlock;
import com.javaweb.vo.Question;
import com.javaweb.vo.QuestionPrint;
import java.util.List;
/*
 * ����������ݱ�����ݲ������׼
 * @author LJW
 */
public interface IQuestionDAO extends IDAO<Question,Integer>{
	/*
	 * ���Ծ��Ҫ������ȡҪ������������ѡȡ�������
	 * @param ab һ���Ծ�飬�����Դ˿���Ŀ��Ҫ��
	 * @param return ��������ܹ������Ծ��Ҫ���򷵻�һ������飬���򷵻�null
	 * @throws Exception �������·û�����ӣ������NullPointerException,���SQL���������׳�SQLException
	 */
	public List<QuestionPrint> getAutoBlockByRequest(AutoBlock ab) throws Exception; 
	/*
	 * 
	 */
	public List<QuestionPrint> getManualPaperQuestion(List<Integer> ids);
	/*
	 * 
	 */
	public List<String[]> getAllTitle() throws Exception;
	/*
	 * ��ȡ��Ҫ��ѯ����Ŀ�Ĳ�����ִ��select����
	 * @param q ���������п��ܲ�ѯ��Ҫ��Ҫ��������;������ļ�����������Ҫ(�ǿ�)
	 * @return �������з��ϲ�ѯҪ�����Ŀ����
	 * @throws Exception  IQuestionDAO�ӿ��е��쳣
	 */
	public List<Question> findQuestionByTitle(Question vo)throws Exception;
	public List<Question> findQuestionByTitleAndDifficulty(Question vo)throws Exception;
	public List<Question> findQuestionByTitleAndIsMulti(Question vo)throws Exception;
	public List<Question> findQuestionByTitleAndAttri(Question vo)throws Exception;
	public Question findQuestionByTitleAndConent(Question vo)throws Exception;
	public Question findQuestionById(Integer id)throws Exception;
}
