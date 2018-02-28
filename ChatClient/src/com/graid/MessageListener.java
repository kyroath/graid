package com.graid;

public interface MessageListener {

    public void onMessage(String fromUsername, String msgBody);
}
