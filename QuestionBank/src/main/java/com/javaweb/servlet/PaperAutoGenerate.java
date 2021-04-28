package com.javaweb.servlet;

import java.io.IOException;
import java.io.InputStreamReader;

import com.javaweb.factory.ServiceFactory;
import com.javaweb.vo.AutoPaper;
import com.javaweb.vo.ObjectListTemplate;
import com.javaweb.vo.QuestionPrint;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

/*
 * Servlet implementation class PaperGenerate
 */
@WebServlet("/PaperAutoGenerate")
public class PaperAutoGenerate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PaperAutoGenerate() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
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
		
		AutoPaper ap = JSON.parseObject(result.toString(),AutoPaper.class);
		
		//保存题目集合
		ObjectListTemplate<QuestionPrint> out = new ObjectListTemplate<QuestionPrint>();
		try {	
			out.setIndex(ServiceFactory.getIPaperGenerateInstance().getAutoPaper(ap));
		} catch (Exception e) {
			out.setIndex(null);
			e.printStackTrace();
		}
		if(!ServiceFactory.getIPaperPrintInstance().createPaperDocument(out.getIndex())) {
			//未生成时设置空值
			out.setIndex(null);
		}
		response.getWriter().write(JSON.toJSONString(out));
		response.getWriter().close();
	}
}
