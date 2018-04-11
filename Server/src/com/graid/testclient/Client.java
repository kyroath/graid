package com.graid.testclient;

import com.graid.handles.Handle;
import com.graid.handles.client.CLoginHandle;
import com.graid.messages.Message;
import com.graid.messages.server.SLoginMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    private final String serverName;
    private final int serverPort;
    private Socket socket;
    private ObjectInputStream serverIn;
    private ObjectOutputStream serverOut;

    public Client(String serverName, int serverPort) {
        this.serverName = serverName;
        this.serverPort = serverPort;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        Client client = new Client("localhost", 8818);
        client.handle();

    }

    private void handle() throws IOException, ClassNotFoundException, InterruptedException {

        connect();

        Handle clientHandle = new CLoginHandle("talha", "talha");
        Message message = clientHandle.handle();
        send(message);

        SLoginMessage loginMessage = (SLoginMessage) serverIn.readObject();
        if (loginMessage.getReturnCode() == 1) {
            startReader();
            System.out.println("You have logged in as: " + loginMessage.getUser().getUsername());
        } else if (loginMessage.getReturnCode() == -1) {
            System.out.println("Login error.");
        }

        serverOut.close();
        serverIn.close();
        socket.close();

    }

    private boolean connect(){

        try {
            this.socket = new Socket(serverName, serverPort);

            System.out.println("Client port is: " + socket.getLocalPort());

            this.serverOut = new ObjectOutputStream(socket.getOutputStream());
            this.serverIn = new ObjectInputStream(socket.getInputStream());

            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    private void startReader() {
        Thread t = new Thread() {
            @Override
            public void run() {
                reader();
            }
        };
    }

    private void reader() {

        //

    }

    private void send(Message message) {
        try {
            serverOut.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
