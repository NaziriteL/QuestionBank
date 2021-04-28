package com.javaweb.servlet;

import java.io.IOException;
import java.io.InputStreamReader;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.javaweb.factory.ServiceFactory;
import com.javaweb.vo.Question;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class QuestionAlter
 */
@WebServlet(description = "提供题目修改服务", urlPatterns = { "/question/alter" })
public class QuestionAlter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public QuestionAlter() {
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
		Question vo = JSON.parseObject(result.toString(), Question.class);
		JSONObject out = new JSONObject();
		try {
			out.put("result", ServiceFactory.getIQuestionOperateInstance().alterQuestion(vo));
			response.getWriter().write(String.valueOf(out));
			response.getWriter().close();
		} catch (Exception e) {
			out.put("result", false);
			response.getWriter().write(String.valueOf(out));
			response.getWriter().close();
			e.printStackTrace();
		}
	}
}
