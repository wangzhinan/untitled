package com.sunland.test.webservice.server;

import javax.xml.ws.Endpoint;

public class PushServer {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/getAddress", new FisrtWebServiceImpl());
        System.out.println("服务发布成功");
    }
}
