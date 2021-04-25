package com.javaweb.service.impl;

import java.util.List;
import com.javaweb.dbc.DBConnection;
import com.javaweb.factory.DAOFactory;
import com.javaweb.service.IUserService;
import com.javaweb.vo.User;

public class UserServiceImpl implements IUserService {
	private DBConnection dbc = new DBConnection();
	@Override
	public boolean[] login(String username,String password) throws Exception{
		
		try {
			return DAOFactory.getIUserDAOInstance(this.dbc.getConnection()).findByIdAndPass(username, password);
		} catch(Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}
	
	@Override
	public boolean register(User vo) throws Exception {
		// TODO Auto-generated method stub
		try {
			return DAOFactory.getIUserDAOInstance(this.dbc.getConnection()).doCreate(vo);
		} catch(Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}
		
	@Override
	public List<User> getUserIndex() throws Exception {
		// TODO Auto-generated method stub
		try {
			return DAOFactory.getIUserDAOInstance(this.dbc.getConnection()).getAll();
		} catch(Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}
	
	@Override
	public boolean alterUserInfo(User vo) throws Exception {
		// TODO Auto-generated method stub
		try {
			return DAOFactory.getIUserDAOInstance(this.dbc.getConnection()).doUpdate(vo);
		} catch(Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}
	
	@Override
	public boolean deleteUserInfo(String username) throws Exception {
		// TODO Auto-generated method stub
		try {
			return DAOFactory.getIUserDAOInstance(this.dbc.getConnection()).doRemove(username);
		} catch(Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}
}
