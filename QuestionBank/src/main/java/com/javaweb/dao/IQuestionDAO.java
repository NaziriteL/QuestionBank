package com.javaweb.dao;

import com.javaweb.vo.AutoBlock;
import com.javaweb.vo.Question;
import com.javaweb.vo.QuestionPrint;
import java.util.List;
/*
 * 定义题库数据表的数据层操作标准
 * @author LJW
 */
public interface IQuestionDAO extends IDAO<Question,Integer>{
	/*
	 * 由试卷块要求，来获取要求的数量的随机选取的试题块
	 * @param ab 一份试卷块，包含对此块题目的要求
	 * @param return 如果数据能够满足试卷块要求，则返回一份试题块，否则返回null
	 * @throws Exception 如果数据路没有连接，则出现NullPointerException,如果SQL语句错误则抛出SQLException
	 */
	public List<QuestionPrint> getAutoBlockByRequest(AutoBlock ab) throws Exception; 
	/*
	 * 
	 */
	public List<QuestionPrint> getManualPaperQuestion(List<Integer> ids) throws Exception;
	/*
	 * 
	 */
	public List<String[]> getAllTitle() throws Exception;
	/*
	 * 获取需要查询的题目的操作，执行select操作
	 * @param q 包含了所有可能查询需要的要求参数，和具体是哪几个参数是需要(非空)
	 * @return 返回所有符合查询要求的题目集合
	 * @throws Exception  IQuestionDAO接口中的异常
	 */
	public List<Question> findQuestionByTitle(Question vo)throws Exception;
	public List<Question> findQuestionByTitleAndDifficulty(Question vo)throws Exception;
	public List<Question> findQuestionByTitleAndIsMulti(Question vo)throws Exception;
	public List<Question> findQuestionByTitleAndAttri(Question vo)throws Exception;
	public Question findQuestionByTitleAndConent(Question vo)throws Exception;
	public Question findQuestionById(Integer id)throws Exception;
}
