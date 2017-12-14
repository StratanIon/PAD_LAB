package com.company;

public class CommandMessageManager {
    private final QueueManager queueManager = QueueManager.getInstance();
    //Message message = new Message();

    public void execute(Message message){
        if(message == null){
            return;
        }

        if (message.getCommand().equalsIgnoreCase("get")) {
            queueManager.getMessageQueue();
        }
        else if(message.getCommand().equalsIgnoreCase("put")){
            queueManager.addMessage(message.getPayload());
        }

    }
}
