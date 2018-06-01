package com.sunland.test.print;

import java.util.Map;

public class TestTemplate extends BaseTemplate<User,PrinterManager>{
    public TestTemplate(User data, Map extras, int totalPage) {
        super(data,extras, totalPage);
    }

    @Override
    public int doPrint(PrinterManager printer, User data, Map extras, int totalPage) throws Exception {
        printer.printText(data.getName());
        return 0;
    }
}
