package com.sunland.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JsonService implements InitializingBean {
    @Autowired
    private IOutService outService;

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    public String process(String methodName, String parameter) {
        Object object = null;
        try {
            Method method = IOutService.class.getMethod(methodName, String.class);
            object = method.invoke(outService, parameter);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return (String) object;
    }
}
