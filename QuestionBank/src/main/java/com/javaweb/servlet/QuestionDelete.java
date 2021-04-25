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
 * Servlet implementation class QuestionDelete
 */
@WebServlet(description = "提供题目删除的服务", urlPatterns = { "/question/delete" })
public class QuestionDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public QuestionDelete() {
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
		JSONObject jsonId = JSON.parseObject(result);
		Integer id = jsonId.getInteger("id");
		
		JSONObject object = new JSONObject()
;		try {
			object.put("result", ServiceFactory.getIQuestionOperateInstance().deleteQuestion(id));
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

