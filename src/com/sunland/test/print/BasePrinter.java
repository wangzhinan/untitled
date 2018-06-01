package com.sunland.test.print;

public abstract class BasePrinter<T,E> implements IPrinter<E> {
    private BaseTemplate<T,E> baseTemplate;
    private PrintStatusListener listener;

    public BasePrinter(BaseTemplate<T,E> baseTemplate, PrintStatusListener listener) {
        this.baseTemplate = baseTemplate;
        this.listener = listener;
    }
    //&#@！anr<>?{}}{{p][]and listener &*%4%'%an阿纳通"

    public void start() {
        new Thread(() -> {
            try {
                int code = baseTemplate.doPrint(getPrinter(), baseTemplate.getData(), baseTemplate.getExtras(), baseTemplate.getTotalPage());
                if (listener != null) {
                    if (code == 0)
                        listener.onSuccess(baseTemplate.getCurrentPage(),baseTemplate.getTotalPage(),this);
                    else
                        listener.onError(baseTemplate.getCurrentPage(),code, getErrMessage(code),this);
                }
            } catch (Exception e) {
                if (listener != null) {
                    listener.onError(baseTemplate.getCurrentPage(),-999, e.getMessage(),this);
                }
            }
        }).start();
    }

    public BaseTemplate<T,E> getBaseTemplate() {
        return baseTemplate;
    }

    public void printNextPage(){
        baseTemplate.setNextPage();
        start();
    }
   public abstract String getErrMessage(int code);
}
