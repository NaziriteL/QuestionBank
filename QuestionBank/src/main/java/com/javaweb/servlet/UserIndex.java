package com.javaweb.servlet;

import java.io.IOException;
import com.alibaba.fastjson.JSON;
import com.javaweb.factory.ServiceFactory;
import com.javaweb.vo.ObjectListTemplate;
import com.javaweb.vo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserIndex
 */
@WebServlet(description = "返回用户账户列表", urlPatterns = { "/user/index" })
public class UserIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public UserIndex() {
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
		
		ObjectListTemplate<User> out = new ObjectListTemplate<User>();
		
		try {
			out.setIndex((ServiceFactory.getIUserServiceInstance().getUserIndex()));
			response.getWriter().write(JSON.toJSONString(out));
			response.getWriter().close();
		} catch (Exception e) {
			response.getWriter().write(JSON.toJSONString(out));
			response.getWriter().close();
			e.printStackTrace();
		}
	}
}
