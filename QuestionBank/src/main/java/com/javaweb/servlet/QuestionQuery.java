package com.javaweb.servlet;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;
import com.javaweb.factory.ServiceFactory;
import com.javaweb.service.IQuestionOperate;
import com.javaweb.vo.ObjectListTemplate;
import com.javaweb.vo.Question;

/**
 * Servlet implementation class QuestionQuery
 */
@WebServlet(description = "提供多种题目查询方式", urlPatterns = { "/question/query" })
public class QuestionQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public QuestionQuery() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//读取流
		InputStreamReader insr = new InputStreamReader(request.getInputStream(),"utf-8");
		StringBuilder result = new StringBuilder(40);
		int respInt = insr.read();
		while(respInt != -1) {
			result.append((char)respInt);
			respInt = insr.read();
		}
		//System.out.println(result);
		QuestionQueryService qs = JSON.parseObject(result.toString(),QuestionQueryService.class);
		IQuestionOperate qo = ServiceFactory.getIQuestionOperateInstance();
		ObjectListTemplate<Question> out = new ObjectListTemplate<Question>();
		List<Question> list = new ArrayList<Question>();
		/*
		 * 查找服务种类，代表含义：
		 * 0:通过ID查找
		 * 1:通过标题查找
		 * 2:通过标题和标签查找
		 * 3:通过标题和难度值查找
		 * 4:通过标题和是否多选查找
		 * 5:通过标题和题干查找
		 */
		switch(qs.getServiceType()) {
		case 0:
			try {
				list.add(qo.queryQuestionById(Integer.parseInt(qs.getQueryParameter()[0])));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} break;
		case 1:
			try {
				list.addAll(qo.queryQuestionByTitle(qs.getQueryParameter()[0], qs.getQueryParameter()[1]));
			} catch (Exception e) {
				e.printStackTrace();
			} break;
		case 2:
			try {
				list.addAll(qo.queryQuestionByTitleAndAttribute(qs.getQueryParameter()[0], qs.getQueryParameter()[1], Integer.parseInt(qs.getQueryParameter()[2]), Boolean.parseBoolean(qs.getQueryParameter()[3])));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} break;
		case 3:
			try {
				list.addAll(qo.queryQuestionByTitleAndDifficulty(qs.getQueryParameter()[0], qs.getQueryParameter()[1], Integer.parseInt(qs.getQueryParameter()[2])));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} break;
		case 4:
			try {
				list.addAll(qo.queryQuestionByTitleAndIsMulti(qs.getQueryParameter()[0], qs.getQueryParameter()[1], Boolean.parseBoolean(qs.getQueryParameter()[3])));
			} catch (Exception e) {
				e.printStackTrace();
			} break;
		case 5:
			try {
				list.add(qo.queryQuestionByTitleAndContent(qs.getQueryParameter()[0], qs.getQueryParameter()[1], qs.getQueryParameter()[2]));
			} catch (Exception e) {
				e.printStackTrace();
			} break;
		}
		out.setIndex(list);
		response.getWriter().write(JSON.toJSONString(out));
		response.getWriter().close();
	}

}

class QuestionQueryService{
	Integer ServiceType;
	String[] QueryParameter;
	public Integer getServiceType() {
		return ServiceType;
	}
	public void setServiceType(Integer serviceType) {
		ServiceType = serviceType;
	}
	public String[] getQueryParameter() {
		return QueryParameter;
	}
	public void setQueryParameter(String[] queryParameter) {
		QueryParameter = queryParameter;
	}
	
}
