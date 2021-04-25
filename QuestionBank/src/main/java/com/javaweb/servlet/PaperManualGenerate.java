package com.javaweb.servlet;

import java.io.IOException;
import java.io.InputStreamReader;

import com.alibaba.fastjson.JSON;
import com.javaweb.factory.ServiceFactory;
import com.javaweb.vo.ObjectListTemplate;
import com.javaweb.vo.QuestionPrint;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaperManualGenerate
 */
@WebServlet("/PaperManualGenerate")
public class PaperManualGenerate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PaperManualGenerate() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
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
		ObjectListTemplate<Integer>  ids = JSON.parseObject(result,InputIdList.class);
		
		//������Ŀ����
		ObjectListTemplate<QuestionPrint> out = new ObjectListTemplate<QuestionPrint>();
		try {
			out.setIndex(ServiceFactory.getIPaperGenerateInstance().getManualPaper(ids.getIndex()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!ServiceFactory.getIPaperPrintInstance().createPaperDocument(out.getIndex())) {
			//δ����ʱ���ÿ�ֵ
			out.setIndex(null);
		}
		response.getWriter().write(JSON.toJSONString(out));
		response.getWriter().close();
	}
}

class InputIdList extends ObjectListTemplate<Integer>{
}