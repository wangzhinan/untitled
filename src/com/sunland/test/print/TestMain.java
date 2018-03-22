package com.sunland.test.print;

public class TestMain {
    public static void main(String[] args) {
        User user = new User();
        user.setName("admin");
        user.setPassword("123456");
        BaseTemplate template = new TestTemplate(user,null,1);
        PrintStatusListener listener = new PrintStatusListener() {
            @Override
            public void onSuccess(int currentPage) {
                System.out.println("当前页："+currentPage);
            }

            @Override
            public void onError(int currentPage, int errCode, String errMessage) {

            }
        };

        BaseTemplate template1 = new UserTemplate(user,null,2);
        MyPrinter userMyPrinter = new MyPrinter(template1,listener);
        userMyPrinter.start();

    }
}
