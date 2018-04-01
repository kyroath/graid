package com.graid;

import com.graid.messages.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerWorker extends Thread{

    Server server;
    ObjectOutputStream outputStream;
    ObjectInputStream inputStream;

    public ServerWorker(Server server, Socket clientSocket) {

        this.server = server;
        try {

            outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            inputStream = new ObjectInputStream(clientSocket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        try {
            handle();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void handle() throws IOException, ClassNotFoundException {

        Message message;

        while ((message = (Message) inputStream.readObject())!= null) {

            message.handle();

        }

        inputStream.close();
        outputStream.close();

    }
}
