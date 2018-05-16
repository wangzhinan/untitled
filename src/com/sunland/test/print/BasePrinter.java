package com.sunland.test.print;

public abstract class BasePrinter<T> implements IPrinter {
    private BaseTemplate<T> baseTemplate;
    private PrintStatusListener listener;

    public BasePrinter(BaseTemplate<T> baseTemplate, PrintStatusListener listener) {
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
                        listener.onSuccess(baseTemplate.getCurrentPage());
                    else
                        listener.onError(baseTemplate.getCurrentPage(), code, getErrMessage());
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (listener != null) {
                    listener.onError(baseTemplate.getCurrentPage(), -999, getErrMessage());
                }
            }
        }).start();
    }
   public abstract String getErrMessage();
}
