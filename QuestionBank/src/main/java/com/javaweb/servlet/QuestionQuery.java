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
import com.javaweb.vo.Question;

/**
 * Servlet implementation class QuestionQuery
 */
@WebServlet(description = "�ṩ������Ŀ��ѯ��ʽ", urlPatterns = { "/question/query" })
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
		//��ȡ��
		InputStreamReader insr = new InputStreamReader(request.getInputStream(),"utf-8");
		String result = "";
		int respInt = insr.read();
		while(respInt!=-1) {
			result +=(char)respInt;
			respInt = insr.read();
		}
		//System.out.println(result);
		QuestionService qs = JSON.parseObject(result,QuestionService.class);
		IQuestionOperate qo = ServiceFactory.getIQuestionOperateInstance();
		QuestionList out = new QuestionList();
		/*
		 * ���ҷ������࣬�������壺
		 * 0:ͨ��ID����
		 * 1:ͨ���������
		 * 2:ͨ������ͱ�ǩ����
		 * 3:ͨ��������Ѷ�ֵ����
		 * 4:ͨ��������Ƿ��ѡ����
		 * 5:ͨ���������ɲ���
		 */
		switch(qs.getServiceType()) {
		case 0:
			try {
				out.getList().add(qo.queryQuestionById(Integer.parseInt(qs.getQueryParameter()[0])));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} break;
		case 1:
			try {
				out.getList().addAll(qo.queryQuestionByTitle(qs.getQueryParameter()[0], qs.getQueryParameter()[1]));
			} catch (Exception e) {
				e.printStackTrace();
			} break;
		case 2:
			try {
				out.getList().addAll(qo.queryQuestionByTitleAndAttribute(qs.getQueryParameter()[0], qs.getQueryParameter()[1], Integer.parseInt(qs.getQueryParameter()[2]), Boolean.parseBoolean(qs.getQueryParameter()[3])));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} break;
		case 3:
			try {
				out.getList().addAll(qo.queryQuestionByTitleAndDifficulty(qs.getQueryParameter()[0], qs.getQueryParameter()[1], Integer.parseInt(qs.getQueryParameter()[2])));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} break;
		case 4:
			try {
				out.getList().addAll(qo.queryQuestionByTitleAndIsMulti(qs.getQueryParameter()[0], qs.getQueryParameter()[1], Boolean.parseBoolean(qs.getQueryParameter()[3])));
			} catch (Exception e) {
				e.printStackTrace();
			} break;
		case 5:
			try {
				out.getList().add(qo.queryQuestionByTitleAndContent(qs.getQueryParameter()[0], qs.getQueryParameter()[1], qs.getQueryParameter()[2]));
			} catch (Exception e) {
				e.printStackTrace();
			} break;
		}
		response.getWriter().write(JSON.toJSONString(out));
		response.getWriter().close();
	}

}

class QuestionService{
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

class QuestionList{
	List<Question> list;
	public List<Question> getList() {
		return list;
	}
	public void setList(List<Question> list) {
		this.list = list;
	}
}