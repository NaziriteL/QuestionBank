package com.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.InputStreamReader;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.javaweb.factory.ServiceFactory;

/**
 * Servlet implementation class Login
 */
@WebServlet(description = "负责用户登陆验证", urlPatterns = {"/login"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * Default constructor. 
     */
    //protected 
    public Login() {
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doPost(request,response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
					
		JSONObject jsonUser = JSON.parseObject(result.toString());
		String username = jsonUser.getString("username");
		String password = jsonUser.getString("password");
		
		HttpSession session = request.getSession(true);
		JSONObject object = new JSONObject();
		
		try {
			boolean[] res = ServiceFactory.getIUserServiceInstance().login(username, password);
			if(res[0]) {
				//response.setContentType("text/html;charset=UTF-8");
				session.setAttribute("username", username);
				if(res[1]) {
		        	object.put("result","登陆成功，管理账号");
		        	session.setAttribute("isAdmin",true);
					response.getWriter().write(String.valueOf(object));				
					response.getWriter().close();
				}else {
					object.put("result","登陆成功，普通账号");
					session.setAttribute("isAdmin",false);
					response.getWriter().write(String.valueOf(object));		
					response.getWriter().close();
				}
			}else {	
				if(res[1]) {
		        	object.put("result","登陆失败，密码错误");
					response.getWriter().write(String.valueOf(object));
					response.getWriter().close();
				}else {
					object.put("result","登陆失败，用户不存在");
					response.getWriter().write(String.valueOf(object));
					response.getWriter().close();
				}
			}
		}catch(Exception e) {
			response.getWriter().write("unknown error");
			response.getWriter().close();
			e.printStackTrace();
		}		
		/*
			response.setContentType("text/html;charset=UTF-8");
	        response.getWriter().write("5秒后跳转页面.....");
	        //三秒后跳转到index.jsp页面去，web应用的映射路径我设置成/，url没有写上应用名
	        response.setHeader("Refresh", "5;url='JavaWebDemo/index.html'");
		*/
	}
}
