package com.sunland.test.webservice.weatherservice;

public class PhoneAddressClient {

    public static void main(String[] args) {
        System.out.println(getPhoneAddress("15000814726"));
    }

    public static String getPhoneAddress(String phone){
        //1.实例化生成的服务类
        MobileCodeWS ws = new MobileCodeWS();
        //2.调用服务类的方法获取接口实例
        MobileCodeWSSoap soap = ws.getMobileCodeWSSoap();
        //3.通过接口直接获取数据
        return soap.getMobileCodeInfo(phone,"");
    }
}
