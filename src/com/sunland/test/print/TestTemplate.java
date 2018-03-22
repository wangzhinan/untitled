package com.sunland.test.print;

import java.util.Map;

public class TestTemplate extends BaseTemplate<User>{
    public TestTemplate(User data, Map extras, int totalPage) {
        super(data,extras, totalPage);
    }

    @Override
    public int doPrint(Object printer, User data, Map extras, int totalPage) throws Exception {
        PrinterManager manager = (PrinterManager) printer;
        manager.printText(data.getName());
        return 0;
    }
}
