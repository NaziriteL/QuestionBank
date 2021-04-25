package com.javaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.javaweb.dao.IUserDAO;
import com.javaweb.vo.User;

public class UserDAOImpl implements IUserDAO {
	//�ֲ����ݿ����Ӷ���
	private Connection conn;
	//�ֲ�����·��������;
	private PreparedStatement pstmt;
	/*
	* ʵ�������ݲ���Ӳ����ͬʱ����һ�����ݿ����Ӷ���
	* @param conn ��Connection���Ӷ������Ϊnull���ʾ���ݿ�û�д�
	*/
	public UserDAOImpl(Connection conn) {
		this.conn = conn;
	}
	/*
	 * @return ���س���Ϊ2�Ĳ���ֵ���飬��f,f]�����û�������ò�����,[f,t]�����û������������,[t,f]������ͨ�û�,[t,t]��������û�
	 */
	@Override
	public boolean[] findByIdAndPass(String username, String password) throws Exception{
		// TODO Auto-generated method stub
		boolean[] res = new boolean[] {false,false};
		String sql = "SELECT username FROM users WHERE username = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, username);
		ResultSet rs = this.pstmt.executeQuery();
		if(!rs.next()) {
			return res;			
		}
		sql = "SELECT isAdmin FROM users WHERE username = ? AND password = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, username);
		this.pstmt.setString(2, password);
		rs = this.pstmt.executeQuery();
		if(rs.next()) {
			res[0] = true;
			if(rs.getInt(1) == 1) {
				res[1] = true; 
				return res;
			}else {
				return res;
			}		
		}else {
			res[1] = true;
			return res;
		}
		
	}

	@Override
	public boolean doCreate(User vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO users(username, password, isMulti) VALUES(?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getUsername());
		this.pstmt.setString(2, vo.getPassword());
		this.pstmt.setInt(3, vo.getIsAdmin().booleanValue() ? 1 : 0);
		return this.pstmt.executeUpdate() > 0;	
	}

	@Override
	public boolean doUpdate(User vo) throws Exception {
		// TODO Auto-generated method stub		
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE users SET ");
		sql.append(vo.getPassword() != null ? "password = ? ," : "");
		sql.append(vo.getIsAdmin() != null ? "isAdmin = ? ," : "");
		sql.delete(sql.length() - 1, sql.length());
		sql.append("WHERE username = ?");
		this.pstmt = this.conn.prepareStatement(sql.toString());
		int index = 1;
		if(vo.getPassword() != null) {
			this.pstmt.setString(index, vo.getPassword());
			index++;
		}
		if(vo.getIsAdmin() != null) {
			this.pstmt.setInt(index, vo.getIsAdmin().booleanValue() ? 1 : 0);
			index++;
		}
		this.pstmt.setString(index, vo.getUsername());
		return this.pstmt.executeUpdate() == 1;
	}

	@Override
	public boolean doRemove(String username) throws Exception {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM users WHERE username = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1,username);
		return this.pstmt.executeUpdate() == 1;
	}

	@Override
	public List<User> getAll() throws Exception {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		String sql = "SELECT username, password, isAdmin FROM users";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			User vo = new User();
			vo.setUsername(rs.getString(1));
			vo.setPassword(rs.getString(2));
			vo.setIsAdmin(rs.getInt(3) > 0 ? true : false);
			users.add(vo);		
		}
		return users;
	}
}
