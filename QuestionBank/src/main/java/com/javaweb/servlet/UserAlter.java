package com.javaweb.servlet;

import java.io.IOException;
import java.io.InputStreamReader;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.javaweb.factory.ServiceFactory;
import com.javaweb.vo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class 
 */
@WebServlet(description = "用户账户信息修改", urlPatterns = { "/user/alter" })
public class UserAlter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor. 
     */
    public UserAlter() {
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
		InputStreamReader insr = new InputStreamReader(request.getInputStream(), "utf-8");
		String result = "";
		int respInt = insr.read();
		while (respInt != -1) {
			result += (char) respInt;
			respInt = insr.read();
		}
		//System.out.println(result);	
		User user = JSON.parseObject(result, User.class);
		JSONObject object = new JSONObject();
		try {
			object.put("result", ServiceFactory.getIUserServiceInstance().alterUserInfo(user));
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
