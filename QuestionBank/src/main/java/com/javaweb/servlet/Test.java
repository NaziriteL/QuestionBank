package com.javaweb.servlet;

import java.io.IOException;
import java.io.InputStreamReader;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.javaweb.vo.ObjectListTemplate;
import com.javaweb.vo.Question;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuestionInput
 */
@WebServlet(description = "提供用户输入题目服务测试", urlPatterns = { "/question/test" })
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public Test() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		StringBuilder result = new StringBuilder(100);
		int respInt = insr.read();
		while(respInt != -1) {
			result.append((char)respInt);
			respInt = insr.read();
		}
		System.out.println(result);	
		ObjectListTemplate<Question> out = JSON.parseObject(result.toString(), InputQuestionList.class);
		JSONObject object = new JSONObject();
		
		
		for(Question vo: out.getIndex()) {
			if(vo.getMainTitle().length() > 254) {
				object.put("result","主标题超过255字符长度");
				response.getWriter().write(String.valueOf(object));				
				response.getWriter().close();
				return;
			}
			if(vo.getSubTitle().length() > 254) {
				object.put("result","主标题超过255字符长度");
				response.getWriter().write(String.valueOf(object));				
				response.getWriter().close();
				return;
			}
			if(vo.getContent().length() > 254) {
				object.put("result","题干超过255字符长度");
				response.getWriter().write(String.valueOf(object));				
				response.getWriter().close();
				return;
			}
			if((vo.getOptions()[0].length() + vo.getOptions()[1].length() + vo.getOptions()[2].length() + vo.getOptions()[3].length()) > 980) {
				object.put("result","选项总长超过980字符长度");
				response.getWriter().write(String.valueOf(object));				
				response.getWriter().close();
				return;
			}
			if(vo.getAnswer() <= 0 || vo.getAnswer() > 9999) {
				object.put("result","答案数据不符合规范");
				response.getWriter().write(String.valueOf(object));				
				response.getWriter().close();
				return;
			}
		}
		object.put("result", "录入成功");
		response.getWriter().write(String.valueOf(object));				
		response.getWriter().close();
		/*
		try {
			if(ServiceFactory.getIQuestionOperateInstance().inputQuestion(out.getIndex())) {
				object.put("result", "录入成功");
			} else {
				object.put("result", "录入失败");
			}	
			response.getWriter().write(String.valueOf(object));				
			response.getWriter().close();
		} catch (Exception e) {
			object.put("result", "未知错误");
			response.getWriter().write(String.valueOf(object));				
			response.getWriter().close();
			e.printStackTrace();
		}
		*/
	}
}
