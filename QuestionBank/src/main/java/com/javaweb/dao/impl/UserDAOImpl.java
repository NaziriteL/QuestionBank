package com.javaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.javaweb.dao.IUserDAO;
import com.javaweb.vo.User;

public class UserDAOImpl implements IUserDAO {
	//局部数据库连接对象
	private Connection conn;
	//局部数据路操作对象;
	private PreparedStatement pstmt;
	/*
	* 实例化数据层的子层对象，同时传入一个数据库连接对象
	* @param conn 是Connection连接对象，如果为null则表示数据库没有打开
	*/
	public UserDAOImpl(Connection conn) {
		this.conn = conn;
	}
	/*
	 * @return 返回长度为2的布尔值数组，【f,f]代表用户则代表用不存在,[f,t]代表用户输入密码错误,[t,f]代表普通用户,[t,t]代表管理用户
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
