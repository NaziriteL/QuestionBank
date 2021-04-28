package com.javaweb.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		ObjectListTemplate<TitleBlock> out = new ObjectListTemplate<TitleBlock>();
		List<TitleBlock> titleIndex = new ArrayList<TitleBlock>();
		TitleBlock tb = new TitleBlock();
		try {
			List<String[]> res = ServiceFactory.getIQuestionOperateInstance().getQuestionIndex();
			String beforeMainTitle = res.get(0)[0];
			List<String> subTitleIndex = new ArrayList<String>();
			for(String[] i : res) {
				if(i[0].equals(beforeMainTitle)) {
					subTitleIndex.add(i[1]);
				} else {
					tb.setMainTitle(beforeMainTitle);
					tb.setSubTitle(subTitleIndex);
					beforeMainTitle = i[0];
					subTitleIndex.clear();
					titleIndex.add(tb);
					subTitleIndex.add(i[1]);
				}	
			}
			tb.setMainTitle(beforeMainTitle);
			tb.setSubTitle(subTitleIndex);
			titleIndex.add(tb);
			out.setIndex(titleIndex);
			response.getWriter().write(JSON.toJSONString(out));
			response.getWriter().close();
		} catch (Exception e) {
			response.getWriter().write(JSON.toJSONString(out));
			response.getWriter().close();
			e.printStackTrace();
		}
	}
}

class TitleBlock{
	private String mainTitle;
	private List<String> subTitle;
	public String getMainTitle() {
		return mainTitle;
	}
	public void setMainTitle(String mainTitle) {
		this.mainTitle = mainTitle;
	}
	public List<String> getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(List<String> subTitle) {
		this.subTitle = subTitle;
	}	
}