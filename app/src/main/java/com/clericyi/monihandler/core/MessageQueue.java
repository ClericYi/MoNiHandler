package com.clericyi.monihandler.core;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * author: ClericYi
 * time: 2020-02-10
 */
public class MessageQueue {

    BlockingQueue<Message> mQueue = new ArrayBlockingQueue<>(64);
    public void enqueueMessage(Message message) {
        try{
            mQueue.add(message);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public Message next(){
        try {
            return mQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
