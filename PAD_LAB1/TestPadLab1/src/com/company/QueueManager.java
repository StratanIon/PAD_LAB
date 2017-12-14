package com.company;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueManager {
   private final Queue messageQueue = new LinkedBlockingQueue() ;
   
   private static final QueueManager _INSTANCE = new QueueManager();
   
   private QueueManager() {
   }
   
   public static synchronized QueueManager getInstance() {
	   return _INSTANCE;
   }

    public String getMessageQueue() {
        return (String) messageQueue.poll();
    }
    public void addMessage(String message){
        messageQueue.add(message);
    }

}
