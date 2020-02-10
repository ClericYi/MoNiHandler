package com.clericyi.monihandler.core;

/**
 * author: ClericYi
 * time: 2020-02-10
 */
public class Handler {

    private MessageQueue mQueue;
    private Looper mLooper;

    protected Handler(){
        mLooper = Looper.myLooper();
        if(mLooper == null){
            throw new RuntimeException();
        }
        mQueue = mLooper.mQueue;
    }

    public void dispatchMessage(Message message){
        handleMessage(message);
    }


    public void handleMessage(Message message){

    }

    public void sendMessage(Message message){
        enqueueMessage(message);
    }

    private void enqueueMessage(Message message) {
        message.target = this;
        mQueue.enqueueMessage(message);
    }
}
