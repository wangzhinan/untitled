package com.sunland.test.filter;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {
    private List<Filter> filters = new ArrayList<Filter>();
    private int index = 0;
    public FilterChain addFilter(Filter filter){
        filters.add(filter);
        return this;
    }
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        if (index == filters.size())
            return;
        Filter filter = filters.get(index);
        index ++;
        filter.doFilter(request,response,chain);
    }
    @Test
    public void testFilteChain(){
        Request request = new Request();
        request.setRequest("AcdefghB");
        Response response = new Response();
        response.setResponse("response");
        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new SenstiveFilter());
        filterChain.addFilter(new HtmlFilter());
        filterChain.doFilter(request,response,filterChain);
        System.out.println(request.getRequest());
        System.out.println(response.getResponse());
    }

}
