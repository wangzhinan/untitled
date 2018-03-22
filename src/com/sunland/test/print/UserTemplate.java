package com.sunland.test.print;

import java.util.Map;

public class UserTemplate extends BaseTemplate<User> {

    public UserTemplate(User data, Map<String, Object> extras, int totalPage) {
        super(data, extras, totalPage);
    }

    @Override
    public int doPrint(Object printer, User data, Map<String, Object> extras, int totalPage) throws Exception {

        return 0;
    }
}
