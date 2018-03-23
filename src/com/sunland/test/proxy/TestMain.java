package com.sunland.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestMain {
	public static void main(String[] args){
		UserService userService = new UserServiceImpl();  
        InvocationHandler invocationHandler = new LogHandler(userService);  
        UserService userServiceProxy = (UserService)Proxy.newProxyInstance(userService.getClass().getClassLoader(),  
        		userService.getClass().getInterfaces(), invocationHandler);  
        System.out.println(userServiceProxy.getName(1));  
        System.out.println(userServiceProxy.getAge(1));  
	}
}
