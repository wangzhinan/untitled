package com.sunland.test.filter;

public class HtmlFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        String requestStr = request.getRequest().replace("A","a");
        request.setRequest(requestStr);
        chain.doFilter(request,response,chain);
        response.setResponse("<"+response.getResponse()+">");
    }
}
