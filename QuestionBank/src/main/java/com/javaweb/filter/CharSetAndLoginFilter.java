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
		//��servletRequestת��ΪHttpServletRequest
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		//ͳһ����ΪUTF-8
		request.setCharacterEncoding("utf-8");
		String currentURL = request.getRequestURI();
		String contextPath = request.getContextPath();
		//������Ŀ����ʱ����ҳ�浱ǰ·��
		String targetURL = currentURL.substring(contextPath.length());
		HttpSession session = request.getSession(false);//��ȡ����session��ʱ�򣬲����Զ�����session�����ǻ᷵��null
		//�Ե�ǰҳ������жϣ������ǰҳ�治Ϊ��¼ҳ��
		if(session != null && session.getAttribute("username") != null){
			if(targetURL.equals(ADMIN_PAGE)) {
				if((boolean) session.getAttribute("isMulti")) {
					//�����ʾ��ȷ����ȥѰ����һ��������������ڣ������������ҳ����ת		
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