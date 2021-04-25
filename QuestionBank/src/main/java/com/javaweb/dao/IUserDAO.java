package com.javaweb.dao;

import java.util.List;
import com.javaweb.vo.User;

public interface IUserDAO extends IDAO<User,String>{
	public boolean[] findByIdAndPass(String username, String password) throws Exception;
	public List<User> getAll() throws Exception;	
}
