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
@WebServlet(description = "�����û���½��֤", urlPatterns = {"/login"})
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
		
		//��ȡ��
		InputStreamReader insr = new InputStreamReader(request.getInputStream(),"utf-8");
		String result = "";
		int respInt = insr.read();
		while(respInt!=-1) {
			result +=(char)respInt;
			respInt = insr.read();
		}
		System.out.println(result);
					
		JSONObject jsonUser = JSON.parseObject(result);
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
		        	object.put("result","��½�ɹ��������˺�");
		        	session.setAttribute("isAdmin",true);
					response.getWriter().write(String.valueOf(object));				
					response.getWriter().close();
					//response.setHeader("Refresh", "5;url='QuestionBank/404.html'");
				}else {
					object.put("result","��½�ɹ�����ͨ�˺�");
					session.setAttribute("isAdmin",false);
					response.getWriter().write(String.valueOf(object));		
					response.getWriter().close();
				}
			}else {	
				if(res[1]) {
		        	object.put("result","��½ʧ�ܣ��������");
					response.getWriter().write(String.valueOf(object));
					response.getWriter().close();
				}else {
					object.put("result","��½ʧ�ܣ��û�������");
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
	        response.getWriter().write("5�����תҳ��.....");
	        //�������ת��index.jspҳ��ȥ��webӦ�õ�ӳ��·�������ó�/��urlû��д��Ӧ����
	        response.setHeader("Refresh", "5;url='JavaWebDemo/index.html'");
		*/
	}
}