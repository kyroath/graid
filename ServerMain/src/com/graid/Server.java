package com.graid;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread {

    private final int port;
    ArrayList<ServerWorker> workerList = new ArrayList<>();

    Server(int port) {
        this.port = port;
    }

    public ArrayList<ServerWorker> getWorkerList() {
        return workerList;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {

                System.out.println("About to accept connections...");

                Socket clientSocket = serverSocket.accept();

                System.out.println("Accepted connection from " + clientSocket);

                ServerWorker serverWorker = new ServerWorker(this, clientSocket);
                workerList.add(serverWorker);
                serverWorker.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes from active workerList
     * @param serverWorker
     */
    public void removeWorker(ServerWorker serverWorker) {
        workerList.remove(serverWorker);
    }
}
