package com.javaweb.service;

import java.util.List;
import com.javaweb.vo.User;

public interface IUserService {
	/*
	 * �û���½����
	 */
	public boolean[] login(String username,String password) throws Exception;
	/*
	 * �û�ע�᷽��
	 */
	public boolean register(User vo) throws Exception;
	/*
	 * ��ȡ�����û��б���
	 */
	public List<User> getUserIndex() throws Exception;
	/*
	 * �޸��û���Ϣ����
	 */
	public boolean alterUserInfo(User vo) throws Exception;
	/*
	 * ɾ���û���Ϣ����
	 */
	public boolean deleteUserInfo(String username) throws Exception;

}
