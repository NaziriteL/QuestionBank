package com.javaweb.servlet;

import java.io.IOException;
import com.alibaba.fastjson.JSON;
import com.javaweb.factory.ServiceFactory;
import com.javaweb.vo.ObjectListTemplate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuestionIndex
 */
@WebServlet(description = "返回题库所有章节标题目录", urlPatterns = { "/question/index" })
public class QuestionIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public QuestionIndex() {
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
		ObjectListTemplate<String[]> out = new ObjectListTemplate<String[]>();
		try {
			out.setIndex(ServiceFactory.getIQuestionOperateInstance().getQuestionIndex());
			response.getWriter().write(JSON.toJSONString(out));
			response.getWriter().close();
		} catch (Exception e) {
			response.getWriter().write(JSON.toJSONString(out));
			response.getWriter().close();
			e.printStackTrace();
		}
	}
}
