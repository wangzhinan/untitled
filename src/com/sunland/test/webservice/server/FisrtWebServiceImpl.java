package com.sunland.test.webservice.server;

import javax.jws.WebService;

@WebService
public class FisrtWebServiceImpl implements FisrtWebService {
    @Override
    public String getAddressByPhoneNo(String phoneNo) {
        return "上海";
    }
}
