package com.sunland.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {
	private Object target;  
	  
	LogHandler() {  
        super();  
    }  
  
	LogHandler(Object target) {  
        super();  
        this.target = target;  
    }  
  
    @Override  
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {  
        if("getName".equals(method.getName())){  
            System.out.println("++++++before " + method.getName() + "++++++");  
            Object result = method.invoke(target, args);  
            System.out.println("++++++after " + method.getName() + "++++++");  
            return result;  
        }else{  
            Object result = method.invoke(target, args);  
            return result;  
        }  
  
    }  
}
