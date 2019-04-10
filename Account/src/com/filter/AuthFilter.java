package com.filter;

import com.models.entity.Account;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {



    @Override
    public void init(FilterConfig args) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        HttpSession session = req.getSession();
        Account acc = (Account)session.getAttribute("currAcc");
        String url = req.getRequestURI();
        System.out.println(url);
        String contextPath = req.getContextPath();
       
        if (url.contains("ogin.do")||url.contains("ogout.do")||url.contains("yan.do")) {
        	filterChain.doFilter(request, response);
            
        }else if(url.contains("otherAccount")&&acc!=null) {
        	 if(acc.getIs_admin().equals("yes")) {
        		 
              	System.out.println(acc.getIs_admin());
              	filterChain.doFilter(request, response);
              	 
              }else {
              	session.setAttribute("admin", "请采用管理员账户进行登录");
            	filterChain.doFilter(request, response);
            	//return;
              	//res.sendRedirect("toLogin.do");
              }
        }else if(!url.contains("ogin.do")&&!url.contains("ogout.do")&&!url.contains("otherAccount")&&acc!=null) {
        	System.out.println(acc.getIs_admin());
          	filterChain.doFilter(request, response);
        }
        else {
        	res.sendRedirect(contextPath+"/toLogin.do");
        }
       

    }

    @Override
    public void destroy() {

    }


}

