package com.javaweb.service;

import java.util.List;

import com.javaweb.vo.Question;

public interface IQuestionOperate {
	/*
	 * 录入新题目的操作，执行insert操作
	 * @param q 包含了题目的全部信息，除了id是插入数据库自动赋值的，以方便数据库进行索引
	 * @return 如果数据录入成功则返回true，否则返回false
	 * @throws Exception IQuestionDAO接口中的异常
	 */
	public boolean inputQuestion(List<Question> vos)throws Exception;
	/*
	 * 获取题库中的所有目录
	 * @return 返回一个长度为2的数组的列表，即{[主标题][副标题],[主标题][副标题]...}
	 */
	public List<String[]> getQuestionIndex()throws Exception;	
	/*
	 * 修改需要修改的题目的操作，执行select和update操作
	 * @param qq 包含了所有可能查询需要的要求参数，和具体是哪几个参数是需要
	 * @param 
	 */
	public boolean alterQuestion(Question vo)throws Exception;
	/*
	 * 删除选定的题目的操作，执行doRemove()方法
	 * @param mainTitle 包含了需要删除题目的主标题
	 * @param subTitle 包含了需要删除题目的副标题
	 * @param content 包含了需要删除题目的题干
	 * @return 如果删除成功则返回true,否则返回false 
	 */
	public boolean deleteQuestion(Integer id)throws Exception;
	/*
	 * 获取需要查询的题目的操作，执行findQuestion()方法
	 * @param 包含了所有可能查询需要的要求参数
	 * @return 返回所有符合查询要求的题目集合
	 * @throws Exception  IQuestionDAO接口中的异常
	 */
	public List<Question> queryQuestionByTitle(String mainTitle, String subTitle)throws Exception;
	public List<Question> queryQuestionByTitleAndAttribute(String mainTitle, String subTitle, Integer difficulty, Boolean isMulti)throws Exception;
	public List<Question> queryQuestionByTitleAndDifficulty(String mainTitle, String subTitle, Integer difficulty)throws Exception;
	public List<Question> queryQuestionByTitleAndIsMulti(String mainTitle, String subTitle, Boolean isMulti)throws Exception;
	/*
	 * 通过标题和题干，找到唯一确定一道题目方法
	 */
	public Question queryQuestionByTitleAndContent(String mainTitle, String subTitle, String content)throws Exception;
	/*
	 * 通过ID找到唯一一道题目方法唯一
	 */
	public Question queryQuestionById(Integer id)throws Exception;
}
