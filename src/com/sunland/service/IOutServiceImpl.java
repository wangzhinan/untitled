package com.sunland.service;

import com.sunland.dto.RetLogin;
import org.springframework.beans.factory.annotation.Autowired;

public class IOutServiceImpl implements IOutService {
    @Autowired
    private IUserService iuserService;
    @Override
    public RetLogin login(String input) {
        return iuserService.login(input);
    }
}
