package com.sunland.test.webservice.myservice;


import org.junit.jupiter.api.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 两个类具有相同的 XML 类型名称 "{http://server.webservice.test.sunland.com/}getAddressByPhoneNo"。
 * 请使用 @XmlType.name 和 @XmlType.namespace 为类分配不同的名称。
 * 在对应的类下分配namespace
 * 使用cmd命令下使用wsimport -help 命令查看帮助菜单
 * eg:wsimport -s D:/data -encoding utf-8 http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl
 */
public class PhoneClient {
    public static void main(String[] args) throws MalformedURLException {


    }

    @Test
    public void test1(){
        FisrtWebServiceImplService service = new FisrtWebServiceImplService();
        FisrtWebServiceImpl fisrtWebServiceImplPort = service.getFisrtWebServiceImplPort();
        System.out.println(fisrtWebServiceImplPort.getAddressByPhoneNo("dfd"));
    }

    @Test
    public void test2() throws Exception{
        //        FisrtWebServiceImplService是自动生成的接口，不是服务端的实现类
        Service service = Service.create(new URL("http://localhost:9999/getAddress?wsdl")
                , new QName("http://server.webservice.test.sunland.com/","FisrtWebServiceImplService"));
        FisrtWebServiceImpl impl = service.getPort(FisrtWebServiceImpl.class);
        System.out.println(impl.getAddressByPhoneNo("15000815726"));
    }
}
