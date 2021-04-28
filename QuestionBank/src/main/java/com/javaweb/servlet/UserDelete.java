package com.javaweb.servlet;

import java.io.IOException;
import java.io.InputStreamReader;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.javaweb.factory.ServiceFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserDelete
 */
@WebServlet(description = "删除用户信息", urlPatterns = { "/user/delete" })
public class UserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Default constructor. 
	 */
	public UserDelete() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.setCharacterEncoding("UTF-8");
		//读取流
		InputStreamReader insr = new InputStreamReader(request.getInputStream(),"utf-8");
		StringBuilder result = new StringBuilder(40);
		int respInt = insr.read();
		while(respInt != -1) {
			result.append((char)respInt);
			respInt = insr.read();
		}
		//System.out.println(result);	
		String username = JSON.parseObject(result.toString()).getString("username");
		JSONObject object = new JSONObject();
		try {
			object.put("result", ServiceFactory.getIUserServiceInstance().deleteUserInfo(username));
			response.getWriter().write(String.valueOf(object));
			response.getWriter().close();
		} catch (Exception e) {
			object.put("result", false);
			response.getWriter().write(String.valueOf(object));
			response.getWriter().close();
			e.printStackTrace();
		}
	}
}
