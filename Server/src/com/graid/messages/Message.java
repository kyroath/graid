package com.graid.messages;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class Message {

    ObjectOutputStream outputStream;

    public Message(ObjectOutputStream outputStream) {

        this.outputStream = outputStream;

    }

    public void send() {
        try {
            outputStream.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handle() {
        //
    }

}
