package com.graid;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread{

    int port;
    ArrayList<ServerWorker> workerList;

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

                Socket clientSocket = serverSocket.accept();

                ServerWorker serverWorker = new ServerWorker(this, clientSocket);
                workerList.add(serverWorker);

                serverWorker.start();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

