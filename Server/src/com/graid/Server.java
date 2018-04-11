package com.graid;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Server extends Thread {

    private final int port;
    ArrayList<ServerWorker> workerList = new ArrayList<>();
    HashMap<User, ServerWorker> onlineList = new HashMap<>();

    public ArrayList<ServerWorker> getWorkerList() {
        return workerList;
    }

    public Server(int port) {
        this.port = port;
    }

    @Override
    public void run() {

        try {

            ServerSocket serverSocket = new ServerSocket(port);

            while (true) {

                System.out.println("Accepting connections...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket);

                ServerWorker worker = new ServerWorker(this, clientSocket);
                workerList.add(worker);
                worker.start();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeWorker(ServerWorker worker) {
        workerList.remove(worker);
    }

    public void addOnline(User user, ServerWorker serverWorker) {
        onlineList.put(user, serverWorker);
    }

    public void removeOnline(User user) {
        onlineList.remove(user);
    }
}

