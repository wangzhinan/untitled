package com.sunland.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

@WebFilter(filterName="logFilter",urlPatterns="/*")
public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Map<String,String[]> requestMap = request.getParameterMap();
        Iterator<String> iterator = requestMap.keySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next()+" = "+Arrays.toString(requestMap.get(iterator.next())));
        }
        String reqstr = request.getParameter("request");
        if (reqstr == null) {
            System.out.println("norequest");
        }else {
            System.out.println(reqstr);
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("LogFilter.destroy");
    }
}
