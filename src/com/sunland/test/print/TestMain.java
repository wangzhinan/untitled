package com.sunland.test.print;

import java.io.Serializable;

public class TestMain {
    private static PrintStatusListener listener = new PrintStatusListener() {

        @Override
        public void onSuccess(int currentPage, int totalPage, BasePrinter basePrinter) {
            if (currentPage < totalPage)
                basePrinter.printNextPage();
        }

        @Override
        public void onError(int currentPage, int errCode, String errMessage, BasePrinter basePrinter) {
            System.out.println(errMessage);

        }
    };

    public static void main(String[] args) {
        TestMain testMain = new TestMain();
        testMain.print();
    }

    public void print() {
        User user = new User();
        user.setName("admin");
        user.setPassword("123456");
        BaseTemplate template = getTemplate(0, user);
        BasePrinter printer = getPrinter(template, listener);
        printer.start();

    }

    public BaseTemplate getTemplate(int dataType, Serializable object) {
        BaseTemplate baseTemplate = null;
        switch (dataType) {
            case 0:
                baseTemplate = new UserTemplate((User) object, null, 3);
                break;
            case 1:
                baseTemplate = new TestTemplate(null, null, 3);
                break;
            default:
                break;
        }
        return baseTemplate;
    }

    public BasePrinter getPrinter(BaseTemplate baseTemplate, PrintStatusListener listener) {
        return new MyPrinter(baseTemplate, listener);
    }

}
