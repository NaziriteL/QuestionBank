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
		
		try {
			List<String[]> res = ServiceFactory.getIQuestionOperateInstance().getQuestionIndex();
			TitleBlock tb_last = new TitleBlock();
			List<String> beforeMainTitle = new ArrayList<String>();
			beforeMainTitle.add(res.get(0)[0]);
			List<String> subTitleIndex = new ArrayList<String>();
			int begin = 0, end = 0;
			int cnt = 0;
			for(String[] i : res) {
				if(!i[0].equals(beforeMainTitle.get(cnt))) {	
					TitleBlock tb = new TitleBlock();		
					tb.setMainTitle(beforeMainTitle.get(cnt));
					tb.setSubTitle(subTitleIndex.subList(begin, end).toArray(new String[subTitleIndex.subList(begin, end).size()]));
					beforeMainTitle.add(i[0]);
					titleIndex.add(tb);				
					begin = end;
					cnt++;
				}	
				subTitleIndex.add(i[1]);
				end++;
			}
			tb_last.setMainTitle(beforeMainTitle.get(cnt));
			tb_last.setSubTitle(subTitleIndex.subList(begin, end).toArray(new String[subTitleIndex.subList(begin, end).size()]));
			titleIndex.add(tb_last);
			out.setIndex(null);
			response.getWriter().write(JSON.toJSONString(titleIndex));
			response.getWriter().close();
		} catch (Exception e) {
			response.getWriter().write("未知错误");
			response.getWriter().close();
			e.printStackTrace();
		}
	}
}
class TitleBlock{
	private String mainTitle;
	private String[] subTitle;
	public String getMainTitle() {
		return mainTitle;
	}
	public void setMainTitle(String mainTitle) {
		this.mainTitle = mainTitle;
	}
	public String[] getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String[] subTitle) {
		this.subTitle = subTitle;
	}	
}
