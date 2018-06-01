package com.sunland.test.print;

import java.util.Map;

public class UserTemplate extends BaseTemplate<User,PrinterManager> {

    public UserTemplate(User data, Map<String, Object> extras, int totalPage) {
        super(data, extras, totalPage);
    }

    @Override
    public int doPrint(PrinterManager printer, User data, Map<String, Object> extras, int totalPage) throws Exception {
        printer.printText(data.getName());
        return 0;
    }

}
