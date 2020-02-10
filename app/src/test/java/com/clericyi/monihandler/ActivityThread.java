package com.clericyi.monihandler;

import com.clericyi.monihandler.core.Handler;
import com.clericyi.monihandler.core.Looper;
import com.clericyi.monihandler.core.Message;

import org.junit.Test;

/**
 * author: ClericYi
 * time: 2020-02-10
 */
public class ActivityThread {

    @Test
    public void test(){
        Looper.prepare();

        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message message) {
                System.out.println(message.obj.toString());
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.obj = "test";
                handler.sendMessage(message);
            }
        }).start();

        Looper.loop();
    }
}
