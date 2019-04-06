package com.filter;
import com.models.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName="authFilter", urlPatterns={"/*"})
@Component
public class AuthFilter implements Filter {



    @Override
    public void init(FilterConfig args) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        HttpSession session = req.getSession();
        String url = req.getRequestURI();
        System.out.println(url);
        if (url.startsWith("/api")) {
            filterChain.doFilter(request, response);
        } else {
            filterChain.doFilter(request, response);
        }
        //res.sendRedirect("/login");
//

    }

    @Override
    public void destroy() {

    }


}

