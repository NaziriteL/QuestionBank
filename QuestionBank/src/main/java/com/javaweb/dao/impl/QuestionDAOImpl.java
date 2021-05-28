package com.javaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.javaweb.vo.AutoBlock;
import com.javaweb.vo.Question;
import com.javaweb.vo.QuestionPrint;
import com.javaweb.dao.IQuestionDAO;

public class QuestionDAOImpl implements IQuestionDAO {
	//局部数据库连接对象
	private Connection conn;
	//局部数据路操作对象;
	private PreparedStatement pstmt;
	/*
	 * 实例化数据层的子层对象，同时传入一个数据库连接对象
	 * @param conn 是Connection连接对象，如果为null则表示数据库没有打开
	 */
	public QuestionDAOImpl(Connection conn) {
		this.conn=conn;
	}

	@Override
	public List<QuestionPrint> getAutoBlockByRequest(AutoBlock vo, Integer i) throws Exception{
		// TODO Auto-generated method stub
		int maxId;
		int minId;
		List<QuestionPrint> res = new ArrayList<QuestionPrint>();
		if(vo.getSubTitle() != null) {		
			String sql = "SELECT COUNT(*) FROM question_bank WHERE mainTitle = ? AND "
					+"subTitle = ? AND difficulty = ? AND isMulti = ?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, vo.getMainTitle());
			this.pstmt.setString(2, vo.getSubTitle());
			this.pstmt.setInt(3, vo.getDifficulty());
			this.pstmt.setInt(4, vo.getIsMulti().booleanValue() ? 1 : 0);
			ResultSet rs = this.pstmt.executeQuery();
			if(!rs.next()) {
				return null;
			}
			if(rs.getInt("count(*)") < vo.getQuestionAmount()) {
				QuestionPrint temp = new QuestionPrint();
				temp.setContent(Integer.toString(rs.getInt("count(*)")));
				temp.setAnswer(null);
				temp.setAnswer(-i);
				res.add(temp);
				return res;
			}
			
			sql = "SELECT MAX(id) FROM (SELECT id, content, options, answer FROM question_bank "
					+"WHERE mainTitle = ? AND subTitle = ? AND difficulty = ? AND isMulti = ?) as t1";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, vo.getMainTitle());
			this.pstmt.setString(2, vo.getSubTitle());
			this.pstmt.setInt(3, vo.getDifficulty());
			this.pstmt.setInt(4, vo.getIsMulti().booleanValue() ? 1 : 0);
			rs = this.pstmt.executeQuery();
			if(rs.next()) {
				maxId = rs.getInt(1);
			} else {
				return null;
			}
			
			sql = "SELECT MIN(id) FROM (SELECT id, content, options, answer FROM question_bank "
					+"WHERE mainTitle = ? AND subTitle = ? AND difficulty = ? AND isMulti = ?) as t1";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, vo.getMainTitle());
			this.pstmt.setString(2, vo.getSubTitle());
			this.pstmt.setInt(3, vo.getDifficulty());
			this.pstmt.setInt(4, vo.getIsMulti().booleanValue() ? 1 : 0);
			rs = this.pstmt.executeQuery();
			if(rs.next()) {
				minId = rs.getInt(1);
			} else {
				return null;
			}
			
			sql = "SELECT * FROM (SELECT id, content, options, answer FROM question_bank "
					+"WHERE mainTitle = ? AND subTitle = ? AND difficulty = ? AND isMulti = ?) AS t1 JOIN "
					+"(SELECT ROUND(RAND() * (? - ?) + ?) AS id) AS t2 "
					+"WHERE t1.id >= t2.id ORDER BY t1.id LIMIT 1";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, vo.getMainTitle());
			this.pstmt.setString(2, vo.getSubTitle());
			this.pstmt.setInt(3, vo.getDifficulty());
			this.pstmt.setInt(4, vo.getIsMulti().booleanValue() ? 1 : 0);
			this.pstmt.setInt(5, maxId);
			this.pstmt.setInt(6, minId);
			this.pstmt.setInt(7, minId);
			
			int amount = 0;
			List<String> ctt = new ArrayList<String>();
			while(amount < vo.getQuestionAmount()) {
				rs = this.pstmt.executeQuery();
				if(!rs.next()) {
					continue;
				}
				if(ctt.contains(rs.getString(3))) {
					continue;
				}
				QuestionPrint qv =new QuestionPrint();
				qv.setContent(rs.getString(2));
				ctt.add(rs.getString(2));
				qv.setOptions(rs.getString(3).split("---"));
				qv.setAnswer(rs.getInt(4));
				res.add(qv);
				amount++;
			}	
			return res;
		} else {
			String sql = "SELECT COUNT(*) FROM question_bank WHERE mainTitle = ? AND "
					+"difficulty = ? AND isMulti = ?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, vo.getMainTitle());
			this.pstmt.setInt(2, vo.getDifficulty());
			this.pstmt.setInt(3, vo.getIsMulti().booleanValue() ? 1 : 0);
			ResultSet rs = this.pstmt.executeQuery();
			if(!rs.next()) {
				return null;
			}
			if(rs.getInt("count(*)") < vo.getQuestionAmount()) {
				QuestionPrint temp = new QuestionPrint();
				temp.setContent(Integer.toString(rs.getInt("count(*)")));
				temp.setAnswer(null);
				temp.setAnswer(-i);
				res.add(temp);
				return res;
			}
			
			sql = "SELECT MAX(id) FROM (SELECT id, content, options, answer FROM question_bank "
					+"WHERE mainTitle = ? AND difficulty = ? AND isMulti = ?) as t1";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, vo.getMainTitle());
			this.pstmt.setInt(2, vo.getDifficulty());
			this.pstmt.setInt(3, vo.getIsMulti().booleanValue() ? 1 : 0);
			rs = this.pstmt.executeQuery();
			if(rs.next()) {
				maxId = rs.getInt(1);
			} else {
				return null;
			}
			
			sql = "SELECT MIN(id) FROM (SELECT id, content, options, answer FROM question_bank "
					+"WHERE mainTitle = ? AND difficulty = ? AND isMulti = ?) as t1";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, vo.getMainTitle());
			this.pstmt.setInt(2, vo.getDifficulty());
			this.pstmt.setInt(3, vo.getIsMulti().booleanValue() ? 1 : 0);
			rs = this.pstmt.executeQuery();
			if(rs.next()) {
				minId = rs.getInt(1);
			} else {
				return null;
			}
			
			sql = "SELECT * FROM (SELECT id, content, options, answer FROM question_bank "
					+"WHERE mainTitle = ? AND difficulty = ? AND isMulti = ?) AS t1 JOIN "
					+"(SELECT ROUND(RAND() * (? - ?) + ?) AS id) AS t2 "
					+"WHERE t1.id >= t2.id ORDER BY t1.id LIMIT 1";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, vo.getMainTitle());
			this.pstmt.setInt(2, vo.getDifficulty());
			this.pstmt.setInt(3, vo.getIsMulti().booleanValue() ? 1 : 0);
			this.pstmt.setInt(4, maxId);
			this.pstmt.setInt(5, minId);
			this.pstmt.setInt(6, minId);
			
			int amount = 0;
			List<String> ctt = new ArrayList<String>();
			while(amount < vo.getQuestionAmount()) {
				rs = this.pstmt.executeQuery();
				if(!rs.next()) {
					continue;
				}
				if(ctt.contains(rs.getString(3))) {
					continue;
				}
				QuestionPrint qv =new QuestionPrint();
				qv.setContent(rs.getString(2));
				ctt.add(rs.getString(2));
				qv.setOptions(rs.getString(3).split("---"));
				qv.setAnswer(rs.getInt(4));
				res.add(qv);
				amount++;
			}	
			return res;
		}
		
	}
	
	@Override
	public List<QuestionPrint> getManualPaperQuestion(List<Integer> ids) throws Exception {
		String sql ="SELECT content, options, answer FROM question_bank WHERE id = ?";
		ResultSet rs;
		List<QuestionPrint> res = new ArrayList<QuestionPrint>();
		for(Integer id : ids) {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, id);
			rs = this.pstmt.executeQuery();
			if(!rs.next()) {
				return null;
			}
			QuestionPrint qv =new QuestionPrint();
			qv.setContent(rs.getString(1));
			qv.setOptions(rs.getString(2).split("---"));
			qv.setAnswer(rs.getInt(3));
			res.add(qv);
		}
		return res;
	}

	@Override
	public boolean doCreate(Question vo) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		String sql = "INSERT INTO question_bank(mainTitle, subTitle, content, options, answer, difficulty, isMulti) "
				+"VALUES(?, ?, ?, ?, ?, ?, ?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getMainTitle());
		this.pstmt.setString(2, vo.getSubTitle());
		//图文的话这里要重写
		this.pstmt.setString(3, vo.getContent());
		//将四个选项加上分隔符一起录入数据库
		for(String str : vo.getOptions()){
			sb.append(str).append("---");
		}
		sb.delete(sb.length() - 3, sb.length());
		this.pstmt.setString(4, sb.toString());
		this.pstmt.setInt(5, vo.getAnswer());
		this.pstmt.setInt(6, vo.getDifficulty());
		this.pstmt.setInt(7, vo.getIsMulti().booleanValue() ? 1 : 0);
		return this.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doRemove(Integer id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM question_bank WHERE id = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		
		return this.pstmt.executeUpdate() == 1;
	}

	@Override
	public boolean doUpdate(Question vo) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE question_bank SET ");
		sql.append(vo.getMainTitle() != null ? "mainTitle = ? ," : "");
		sql.append(vo.getSubTitle() != null ? "subTitle = ? ," : "");
		sql.append(vo.getContent() != null ? "content = ? ," : "");
		sql.append(vo.getOptions() != null ? "options = ? ," : "");
		sql.append(vo.getAnswer() != null ? "answer = ? ," : "");
		sql.append(vo.getDifficulty() != null ? "difficulty = ? ," : "");
		sql.append(vo.getIsMulti() != null ? "isMulti = ? ," : "");
		sql.delete(sql.length() - 1, sql.length());
		sql.append("WHERE id = ?");
		this.pstmt = this.conn.prepareStatement(sql.toString());
		int index = 1;
		if(vo.getMainTitle() != null) {
			this.pstmt.setString(index, vo.getMainTitle());
			index++;
		}
		if(vo.getSubTitle() != null) {
			this.pstmt.setString(index, vo.getSubTitle());
			index++;
		}
		if(vo.getContent() != null) {
			this.pstmt.setString(index, vo.getContent());
			index++;
		}
		if(vo.getOptions() != null) {
			StringBuffer sb = new StringBuffer();
			for(int i = 0;i < vo.getOptions().length;i++) {
				sb.append(vo.getOptions()[i]).append("---");
			}
			sb.delete(sb.length()-3, sb.length());
			this.pstmt.setString(index, sb.toString());
			index++;
		}
		if(vo.getAnswer() != null) {
			this.pstmt.setInt(index, vo.getAnswer());
			index++;
		}
		if(vo.getDifficulty() != null) {
			this.pstmt.setInt(index, vo.getDifficulty());
			index++;
		}
		if(vo.getIsMulti() != null) {
			this.pstmt.setInt(index, vo.getIsMulti().booleanValue() ? 1 : 0);
			index++;
		}
		this.pstmt.setInt(index, vo.getId());
		return this.pstmt.executeUpdate() == 1;
	}

	@Override
	public List<String[]> getAllTitle() throws Exception {
		// TODO Auto-generated method stub
		List<String[]> res = new ArrayList<String[]>();
		String sql = "SELECT DISTINCT mainTitle, subTitle FROM question_bank ";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery(sql);
		while(rs.next()) {
			String[] s = new String[2];
			s[0] = rs.getString(1);
			s[1] = rs.getString(2);
			res.add(s);
		}
		return res;
	}

	@Override
	public List<Question> findQuestionByTitle(Question vo) throws Exception {
		// TODO Auto-generated method stub
		List<Question> res = new ArrayList<Question>(); 
		String sql = "SELECT id, mainTitle, subTitle, content, options, answer, difficulty, isMulti FROM question_bank "
				+"WHERE mainTitle = ? AND subTitle = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getMainTitle());
		this.pstmt.setString(2, vo.getSubTitle());
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()) {
			Question q = new Question();
			q.setId(rs.getInt(1));
			q.setMainTitle(rs.getString(2));
			q.setSubTitle(rs.getString(3));
			q.setContent(rs.getString(4));
			q.setOptions(rs.getString(5).split("---"));
			q.setAnswer(rs.getInt(6));
			q.setDifficulty(rs.getInt(7));
			q.setIsMulti(rs.getInt(8) == 1);
			res.add(q);
		}
		return res;
	}

	@Override
	public List<Question> findQuestionByTitleAndDifficulty(Question vo) throws Exception {
		// TODO Auto-generated method stub
		List<Question> res = new ArrayList<Question>(); 
		String sql = "SELECT id, mainTitle, subTitle, content, options, answer, difficulty, isMulti FROM question_bank "
				+"WHERE mainTitle = ? AND subTitle = ? AND difficulty = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getMainTitle());
		this.pstmt.setString(2, vo.getSubTitle());
		this.pstmt.setInt(3, vo.getDifficulty());
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()) {
			Question q = new Question();
			q.setId(rs.getInt(1));
			q.setMainTitle(rs.getString(2));
			q.setSubTitle(rs.getString(3));
			q.setContent(rs.getString(4));
			q.setOptions(rs.getString(5).split("---"));
			q.setAnswer(rs.getInt(6));
			q.setDifficulty(rs.getInt(7));
			q.setIsMulti(rs.getInt(8) == 1);
			res.add(q);
		}
		return res;
	}

	@Override
	public List<Question> findQuestionByTitleAndIsMulti(Question vo) throws Exception {
		// TODO Auto-generated method stub
		List<Question> res = new ArrayList<Question>(); 
		String sql = "SELECT id, mainTitle, subTitle, content, options, answer, difficulty, isMulti FROM question_bank "
				+"WHERE mainTitle = ? AND subTitle = ? AND isMulti = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getMainTitle());
		this.pstmt.setString(2, vo.getSubTitle());
		this.pstmt.setInt(3, vo.getIsMulti().booleanValue() ? 1 : 0);
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()) {
			Question q = new Question();
			q.setId(rs.getInt(1));
			q.setMainTitle(rs.getString(2));
			q.setSubTitle(rs.getString(3));
			q.setContent(rs.getString(4));
			q.setOptions(rs.getString(5).split("---"));
			q.setAnswer(rs.getInt(6));
			q.setDifficulty(rs.getInt(7));
			q.setIsMulti(rs.getInt(8) == 1);
			res.add(q);
		}
		return res;
	}
	
	@Override
	public List<Question> findQuestionByTitleAndAttri(Question vo) throws Exception {
		// TODO Auto-generated method stub
		List<Question> res = new ArrayList<Question>(); 
		String sql = "SELECT id, mainTitle, subTitle, content, options, answer, difficulty, isMulti FROM question_bank "
				+"WHERE mainTitle = ? AND subTitle = ? AND difficulty = ? AND isMulti = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getMainTitle());
		this.pstmt.setString(2, vo.getSubTitle());
		this.pstmt.setInt(3, vo.getDifficulty());
		this.pstmt.setInt(4, vo.getIsMulti().booleanValue() ? 1 : 0);
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()) {
			Question q = new Question();
			q.setId(rs.getInt(1));
			q.setMainTitle(rs.getString(2));
			q.setSubTitle(rs.getString(3));
			q.setContent(rs.getString(4));
			q.setOptions(rs.getString(5).split("---"));
			q.setAnswer(rs.getInt(6));
			q.setDifficulty(rs.getInt(7));
			q.setIsMulti(rs.getInt(8) == 1);
			res.add(q);
		}
		return res;
	}
	
	@Override
	public Question findQuestionByTitleAndContent(Question vo) throws Exception {
		// TODO Auto-generated method stub
		Question res = new Question(); 
		String sql = "SELECT id, mainTitle, subTitle, content, options, answer, difficulty, isMulti FROM question_bank "
				+"WHERE mainTitle = ? AND subTitle = ? AND content = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getMainTitle());
		this.pstmt.setString(2, vo.getSubTitle());
		this.pstmt.setString(3, vo.getContent());
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()) {
			res.setId(rs.getInt(1));
			res.setMainTitle(rs.getString(2));
			res.setSubTitle(rs.getString(3));
			res.setContent(rs.getString(4));
			res.setOptions(rs.getString(5).split("---"));
			res.setAnswer(rs.getInt(6));
			res.setDifficulty(rs.getInt(7));
			res.setIsMulti(rs.getInt(8) == 1);
			return res;
		}else {
			return null;
		}	
	}

	@Override
	public Question findQuestionById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Question res = new Question(); 
		String sql = "SELECT id, mainTitle, subTitle, content, options, answer, difficulty, isMulti FROM question_bank "
				+"WHERE id = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()) {
			res.setId(rs.getInt(1));
			res.setMainTitle(rs.getString(2));
			res.setSubTitle(rs.getString(3));
			res.setContent(rs.getString(4));
			res.setOptions(rs.getString(5).split("---"));
			res.setAnswer(rs.getInt(6));
			res.setDifficulty(rs.getInt(7));
			res.setIsMulti(rs.getInt(8) == 1);
			return res;
		}else {
			return null;
		}
	}
}
