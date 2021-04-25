package com.javaweb.factory;

import java.sql.Connection;
import com.javaweb.dao.IQuestionDAO;
import com.javaweb.dao.IUserDAO;
import com.javaweb.dao.impl.QuestionDAOImpl;
import com.javaweb.dao.impl.UserDAOImpl;

public class DAOFactory {
	public static IQuestionDAO getIQuestionDAOInstance(Connection conn) {
		return new QuestionDAOImpl(conn);
	}
	public static IUserDAO getIUserDAOInstance(Connection conn) {
		return new UserDAOImpl(conn);
	}
}
