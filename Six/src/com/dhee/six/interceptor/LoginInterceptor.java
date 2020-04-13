package com.dhee.six.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginInterceptor implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse reponse=(HttpServletResponse)arg1;
		String proName=request.getContextPath();
		if(request.getRequestURI().contains("manager/admin/adm.do")||request.getRequestURI().contains("manager/admin.jsp")){
			arg2.doFilter(arg0, arg1);
		}else{
			String name=(String)request.getSession().getAttribute("adminInfo");
			if(name!=null){
				arg2.doFilter(arg0, arg1);
				return;
			}else{
				reponse.setCharacterEncoding("utf-8");
				reponse.setContentType("text/html");
				reponse.getWriter().write("<script>alert('请先登录！');"
						+ "location.href='"+proName+"/jsp/manager/admin.jsp'</script>");
				return;
			}
		}	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	

}
