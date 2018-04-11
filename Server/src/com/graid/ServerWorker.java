package com.graid;

import com.graid.handles.Handle;
import com.graid.messages.Message;
import com.graid.messages.server.SLoginMessage;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerWorker extends Thread {

    private final Server server;
    private final ObjectOutputStream objectOutputStream;
    private final ObjectInputStream objectInputStream;

    User user = null;

    boolean loggedIn = false;

    ServerWorker(Server server, Socket clientSocket) throws IOException {

        this.server = server;
        this.objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
        this.objectInputStream = new ObjectInputStream(clientSocket.getInputStream());

    }

    @Override
    public void run() {
        try {
            handleClientSocket();
        } catch (EOFException e) {
            //ignore
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void handleClientSocket() throws IOException, ClassNotFoundException {

        Message message;
        while ((message = (Message) objectInputStream.readObject()) != null) {

            Handle serverHandler = message.handle();
            Message serverMessage = serverHandler.handle();
            send(serverMessage);


            // WILL BE CHANGED
            if ((serverMessage instanceof SLoginMessage) && !loggedIn) {
                user = ((SLoginMessage) serverMessage).getUser();
                loggedIn = true;

                server.addOnline(user, this);
            }

        }
    }

    private void send(Message message) {
        try {
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

