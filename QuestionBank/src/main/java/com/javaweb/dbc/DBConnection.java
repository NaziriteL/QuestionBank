package com.javaweb.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	private static final String DB_URL = "jdbc:mysql://localhost:3306/question_bank?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    // 数据库的用户名与密码，需要根据自己的设置
	private static final String USER = "Ether";
	private static final String PASS = "1862mvpHL2";
	private Connection conn = null;
	/*
	 * 连接数据库的方法
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @return
	 */
	public DBConnection(){
		try {
			//System.out.println("测试加载数据库....");
			Class.forName(JDBC_DRIVER);//加载数据库驱动
			//System.out.println("测试加载数据库成功");
			this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
			//System.out.println("测试数据库链接成功");
		} catch(SQLException se) {
			// 处理 JDBC 错误
            se.printStackTrace();
		}
		catch (Exception e) {
			// 处理 加载不到类等错误 错误
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return this.conn;
	}
	/*
	 * 关闭数据库的方法,不管是否连接上，执行此操作都不会出错
	 */
	public void close(){
		if(this.conn != null){	//如果确实取得了连接
			try {	//关闭连接
				this.conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/*public static void main(String[] args) {
		try {
			BaseMysql.getCon();
			System.out.println("测试数据库成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
