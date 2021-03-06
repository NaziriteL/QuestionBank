package com.javaweb.servlet;

import java.io.IOException;
import java.io.InputStreamReader;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.javaweb.factory.ServiceFactory;
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
@WebServlet(description = "提供用户输入题目服务", urlPatterns = { "/question/input" })
public class QuestionInput extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public QuestionInput() {
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
		//System.out.println(result);	
		ObjectListTemplate<Question> out = JSON.parseObject(result.toString(), InputQuestionList.class);
		JSONObject object = new JSONObject();
		
		
		for(Question vo: out.getIndex()) {
			if(vo.getMainTitle() == null || vo.getMainTitle().length() > 86) {
				object.put("result","第"+out.getIndex().indexOf(vo)+"题的题的主标题为空或者超过86字符长度");
				response.getWriter().write(String.valueOf(object));				
				response.getWriter().close();
				return;
			}
			if(vo.getSubTitle() == null || vo.getSubTitle().length() >86) {
				object.put("result","第"+out.getIndex().indexOf(vo)+"题的副标题为空或者超过86字符长度");
				response.getWriter().write(String.valueOf(object));				
				response.getWriter().close();
				return;
			}
			if(vo.getContent() == null || vo.getContent().length() > 330) {
				object.put("result","第"+out.getIndex().indexOf(vo)+"题的题干为空或者超过330字符长度");
				response.getWriter().write(String.valueOf(object));				
				response.getWriter().close();
				return;
			}
			if((vo.getOptions() == null || (vo.getOptions()[0].length() + vo.getOptions()[1].length() + vo.getOptions()[2].length() + vo.getOptions()[3].length()) > 330) ) {
				object.put("result","第"+out.getIndex().indexOf(vo)+"题的选项为空或者总长超过330字符长度");
				response.getWriter().write(String.valueOf(object));				
				response.getWriter().close();
				return;
			}
			if(vo.getAnswer() == null || vo.getAnswer() <= 0 || vo.getAnswer() > 9999) {
				object.put("result","第"+out.getIndex().indexOf(vo)+"题的答案为空数据不符合规范");
				response.getWriter().write(String.valueOf(object));				
				response.getWriter().close();
				return;
			}
		}
		
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
	}
}

class InputQuestionList extends ObjectListTemplate<Question>{
}
