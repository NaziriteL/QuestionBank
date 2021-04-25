package com.javaweb.service;

import java.util.List;

import com.javaweb.vo.Question;

public interface IQuestionOperate {
	/*
	 * ¼������Ŀ�Ĳ�����ִ��insert����
	 * @param q ��������Ŀ��ȫ����Ϣ������id�ǲ������ݿ��Զ���ֵ�ģ��Է������ݿ��������
	 * @return �������¼��ɹ��򷵻�true�����򷵻�false
	 * @throws Exception IQuestionDAO�ӿ��е��쳣
	 */
	public boolean inputQuestion(List<Question> vos)throws Exception;
	/*
	 * ��ȡ����е�����Ŀ¼
	 * @return ����һ������Ϊ2��������б���{[������][������],[������][������]...}
	 */
	public List<String[]> getQuestionIndex()throws Exception;	
	/*
	 * �޸���Ҫ�޸ĵ���Ŀ�Ĳ�����ִ��select��update����
	 * @param qq ���������п��ܲ�ѯ��Ҫ��Ҫ��������;������ļ�����������Ҫ
	 * @param 
	 */
	public boolean alterQuestion(Question vo)throws Exception;
	/*
	 * ɾ��ѡ������Ŀ�Ĳ�����ִ��doRemove()����
	 * @param mainTitle ��������Ҫɾ����Ŀ��������
	 * @param subTitle ��������Ҫɾ����Ŀ�ĸ�����
	 * @param content ��������Ҫɾ����Ŀ�����
	 * @return ���ɾ���ɹ��򷵻�true,���򷵻�false 
	 */
	public boolean deleteQuestion(Integer id)throws Exception;
	/*
	 * ��ȡ��Ҫ��ѯ����Ŀ�Ĳ�����ִ��findQuestion()����
	 * @param ���������п��ܲ�ѯ��Ҫ��Ҫ�����
	 * @return �������з��ϲ�ѯҪ�����Ŀ����
	 * @throws Exception  IQuestionDAO�ӿ��е��쳣
	 */
	public List<Question> queryQuestionByTitle(String mainTitle, String subTitle)throws Exception;
	public List<Question> queryQuestionByTitleAndAttribute(String mainTitle, String subTitle, Integer difficulty, Boolean isMulti)throws Exception;
	public List<Question> queryQuestionByTitleAndDifficulty(String mainTitle, String subTitle, Integer difficulty)throws Exception;
	public List<Question> queryQuestionByTitleAndIsMulti(String mainTitle, String subTitle, Boolean isMulti)throws Exception;
	/*
	 * ͨ���������ɣ��ҵ�Ψһȷ��һ����Ŀ����
	 */
	public Question queryQuestionByTitleAndContent(String mainTitle, String subTitle, String content)throws Exception;
	/*
	 * ͨ��ID�ҵ�Ψһһ����Ŀ����Ψһ
	 */
	public Question queryQuestionById(Integer id)throws Exception;
}
