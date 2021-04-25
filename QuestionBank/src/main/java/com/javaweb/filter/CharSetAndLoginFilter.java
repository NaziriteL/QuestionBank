package com.javaweb.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CharSetAndLoginFilter implements Filter {
	public static final String LOGIN_PAGE = "../index.html";
	public static final String ADMIN_PAGE = "pages/userManage.html";

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//将servletRequest转发为HttpServletRequest
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		//统一请求为UTF-8
		request.setCharacterEncoding("utf-8");
		String currentURL = request.getRequestURI();
		String contextPath = request.getContextPath();
		//除掉项目名称时访问页面当前路径
		String targetURL = currentURL.substring(contextPath.length());
		HttpSession session = request.getSession(false);//获取不到session的时候，不会自动创建session，而是会返回null
		//对当前页面进行判断，如果当前页面不为登录页面
		if(session != null && session.getAttribute("username") != null){
			if(targetURL.equals(ADMIN_PAGE)) {
				if((boolean) session.getAttribute("isMulti")) {
					//这里表示正确，会去寻找下一个链，如果不存在，则进行正常的页面跳转		
					arg2.doFilter(request, response);	
				}else {
					response.sendRedirect(LOGIN_PAGE);	
				}
			}else {
				arg2.doFilter(request, response);	
			}
		}else{
			//request.getRequestDispatcher("/download/2333.docx").forward(request,response);
			response.sendRedirect(LOGIN_PAGE);		
			return;
		}
	}
}