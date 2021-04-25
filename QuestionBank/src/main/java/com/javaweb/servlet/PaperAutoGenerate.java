package com.javaweb.servlet;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.javaweb.factory.ServiceFactory;
import com.javaweb.vo.AutoPaper;
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
		String result = "";
		int respInt = insr.read();
		while(respInt!=-1) {
			result +=(char)respInt;
			respInt = insr.read();
		}
		System.out.println(result);
		
		AutoPaper ap = JSON.parseObject(result,AutoPaper.class);
		
		//保存题目集合
		QuestionPrintTemplate out = new QuestionPrintTemplate();
		try {	
			out.setPaper(ServiceFactory.getIPaperGenerateInstance().getAutoPaper(ap));
		} catch (Exception e) {
			response.sendRedirect("404.html");
			// TODO Auto-generated catch block
			//出错时设置空值
			out.setPaper(null);
			e.printStackTrace();
		}
		
		if(!ServiceFactory.getIPaperPrintInstance().createPaperDocument(out.getPaper())) {
			//未生成时设置空值
			out.setPaper(null);
		}
		response.getWriter().write(JSON.toJSONString(out));
		response.getWriter().close();
	}
}

class QuestionPrintTemplate{
	List<QuestionPrint> Paper;
	public List<QuestionPrint> getPaper() {
		return Paper;
	}
	public void setPaper(List<QuestionPrint> paper) {
		Paper = paper;
	}
}