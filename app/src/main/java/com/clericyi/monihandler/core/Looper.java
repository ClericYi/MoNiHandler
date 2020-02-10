package com.clericyi.monihandler.core;

/**
 * author: ClericYi
 * time: 2020-02-10
 */
public class Looper {
    static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<>();
    public MessageQueue mQueue;

    private Looper(){
        mQueue = new MessageQueue();
    }

    public static void prepare(){
        if(sThreadLocal.get() != null){
            throw new RuntimeException();
        }
        sThreadLocal.set(new Looper());
    }

    public static void loop(){
        Looper looper = myLooper();
        MessageQueue queue = looper.mQueue;

        Message msg;
        while(true){
            msg = queue.next();
            if(msg == null) continue;
            msg.target.dispatchMessage(msg);
        }
    }


    public static Looper myLooper() {
        return sThreadLocal.get();
    }
}
