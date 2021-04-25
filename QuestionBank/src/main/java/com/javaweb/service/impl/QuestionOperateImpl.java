package com.javaweb.service.impl;

import java.util.List;

import com.javaweb.dbc.DBConnection;
import com.javaweb.factory.DAOFactory;
import com.javaweb.service.IQuestionOperate;
import com.javaweb.vo.Question;

public class QuestionOperateImpl implements IQuestionOperate {
	private DBConnection dbc = new DBConnection();
	@Override
	public boolean inputQuestion(List<Question> vos) throws Exception {
		// TODO Auto-generated method stub
		try {
			for(Question vo : vos) {
				if(DAOFactory.getIQuestionDAOInstance(this.dbc.getConnection()).findQuestionByTitleAndConent(vo) == null) {
					if(!DAOFactory.getIQuestionDAOInstance(this.dbc.getConnection()).doCreate(vo)) {
						return false;
					}
				}else {
					return false;
				}
			}
			return true;
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public List<String[]> getQuestionIndex() throws Exception {
		// TODO Auto-generated method stub
		try {
			return DAOFactory.getIQuestionDAOInstance(this.dbc.getConnection()).getAllTitle();
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean alterQuestion(Question vo) throws Exception {
		// TODO Auto-generated method stub
		try {
			return DAOFactory.getIQuestionDAOInstance(this.dbc.getConnection()).doUpdate(vo);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean deleteQuestion(Integer id) throws Exception {
		// TODO Auto-generated method stub
		try {
			return DAOFactory.getIQuestionDAOInstance(this.dbc.getConnection()).doRemove(id);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public List<Question> queryQuestionByTitle(String mainTitle, String subTitle) throws Exception {
		// TODO Auto-generated method stub
		Question vo = new Question();
		vo.setId(null);
		vo.setMainTitle(mainTitle);
		vo.setSubTitle(subTitle);
		vo.setContent(null);
		vo.setOptions(null);
		vo.setAnswer(null);
		vo.setDifficulty(null);
		vo.setIsMulti(null);
		try {
			return DAOFactory.getIQuestionDAOInstance(this.dbc.getConnection()).findQuestionByTitle(vo);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public List<Question> queryQuestionByTitleAndAttribute(String mainTitle, String subTitle, Integer difficulty, Boolean isMulti) throws Exception {
		// TODO Auto-generated method stub
		Question vo = new Question();
		vo.setId(null);
		vo.setMainTitle(mainTitle);
		vo.setSubTitle(subTitle);
		vo.setContent(null);
		vo.setOptions(null);
		vo.setAnswer(null);
		vo.setDifficulty(difficulty);
		vo.setIsMulti(isMulti);
		try {
			return DAOFactory.getIQuestionDAOInstance(this.dbc.getConnection()).findQuestionByTitleAndAttri(vo);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public List<Question> queryQuestionByTitleAndDifficulty(String mainTitle, String subTitle, Integer difficulty) throws Exception {
		// TODO Auto-generated method stub
		Question vo = new Question();
		vo.setId(null);
		vo.setMainTitle(mainTitle);
		vo.setSubTitle(subTitle);
		vo.setContent(null);
		vo.setOptions(null);
		vo.setAnswer(null);
		vo.setDifficulty(difficulty);
		vo.setIsMulti(null);
		try {
			return DAOFactory.getIQuestionDAOInstance(this.dbc.getConnection()).findQuestionByTitleAndDifficulty(vo);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public List<Question> queryQuestionByTitleAndIsMulti(String mainTitle, String subTitle, Boolean isMulti) throws Exception {
		// TODO Auto-generated method stub
		Question vo = new Question();
		vo.setId(null);
		vo.setMainTitle(mainTitle);
		vo.setSubTitle(subTitle);
		vo.setContent(null);
		vo.setOptions(null);
		vo.setAnswer(null);
		vo.setDifficulty(null);
		vo.setIsMulti(isMulti);
		try {
			return DAOFactory.getIQuestionDAOInstance(this.dbc.getConnection()).findQuestionByTitleAndIsMulti(vo);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public Question queryQuestionByTitleAndContent(String mainTitle, String subTitle,String content) throws Exception {
		// TODO Auto-generated method stub
		Question vo = new Question();
		vo.setId(null);
		vo.setMainTitle(mainTitle);
		vo.setSubTitle(subTitle);
		vo.setContent(content);
		vo.setOptions(null);
		vo.setAnswer(null);
		vo.setDifficulty(null);
		vo.setIsMulti(null);
		try {
			return DAOFactory.getIQuestionDAOInstance(this.dbc.getConnection()).findQuestionByTitleAndConent(vo);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public Question queryQuestionById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		try {
			return DAOFactory.getIQuestionDAOInstance(this.dbc.getConnection()).findQuestionById(id);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}
}
