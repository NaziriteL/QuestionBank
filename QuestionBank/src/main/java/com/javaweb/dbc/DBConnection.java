package com.javaweb.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	private static final String DB_URL = "jdbc:mysql://localhost:3306/question_bank?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    // ���ݿ���û��������룬��Ҫ�����Լ�������
	private static final String USER = "Ether";
	private static final String PASS = "1862mvpHL2";
	private Connection conn = null;
	/*
	 * �������ݿ�ķ���
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @return
	 */
	public DBConnection(){
		try {
			//System.out.println("���Լ������ݿ�....");
			Class.forName(JDBC_DRIVER);//�������ݿ�����
			//System.out.println("���Լ������ݿ�ɹ�");
			this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
			//System.out.println("�������ݿ����ӳɹ�");
		} catch(SQLException se) {
			// ���� JDBC ����
            se.printStackTrace();
		}
		catch (Exception e) {
			// ���� ���ز�����ȴ��� ����
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return this.conn;
	}
	/*
	 * �ر����ݿ�ķ���,�����Ƿ������ϣ�ִ�д˲������������
	 */
	public void close(){
		if(this.conn != null){	//���ȷʵȡ��������
			try {	//�ر�����
				this.conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/*public static void main(String[] args) {
		try {
			BaseMysql.getCon();
			System.out.println("�������ݿ�ɹ�");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
