package com.javaweb.service;

import java.util.List;
import com.javaweb.vo.User;

public interface IUserService {
	/*
	 * 用户登陆方法
	 */
	public boolean[] login(String username,String password) throws Exception;
	/*
	 * 用户注册方法
	 */
	public boolean register(User vo) throws Exception;
	/*
	 * 获取所有用户列表方法
	 */
	public List<User> getUserIndex() throws Exception;
	/*
	 * 修改用户信息方法
	 */
	public boolean alterUserInfo(User vo) throws Exception;
	/*
	 * 删除用户信息方法
	 */
	public boolean deleteUserInfo(String username) throws Exception;

}
