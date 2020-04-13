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

import com.dhee.six.vo.Corporate;
public class IndexLoginInterceptor implements Filter{

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
		String uri=request.getRequestURI();
		String proName=request.getContextPath();	
		if(uri.contains("personal.jsp")||uri.contains("addProtection")||uri.contains("my_info")||uri.contains("resetPassword")||uri.contains("resetProtection")){
			Corporate c =(Corporate)request.getSession().getAttribute("corporate");
			if(c!=null){
				arg2.doFilter(arg0, arg1);
				return;
			}else{
				reponse.setCharacterEncoding("utf-8");
				reponse.setContentType("text/html");
				reponse.getWriter().write("<script>alert('请先登录！');"
						+ "top.location.href='"+proName+"/jsp/index/company/Login.jsp'</script>");
				return;
			}
		}
		arg2.doFilter(arg0, arg1);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	

}
