package com.graid;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Hashtable;

import org.apache.commons.lang3.StringUtils;

public class ServerWorker extends Thread {

    private final Server server;
    private final Socket clientSocket;
    private String username = null;

    InputStream inputStream;
    OutputStream outputStream;

    ServerWorker(Server server, Socket clientSocket) {
        this.server = server;
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            handleClientSocket();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }

    private void handleClientSocket() throws IOException {

        this.inputStream = clientSocket.getInputStream();
        this.outputStream = clientSocket.getOutputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while ( (line = reader.readLine()) != null) {
            String[] tokens = StringUtils.split(line);

            // Read commands
            if (tokens != null && tokens.length > 0) {
                String cmd = tokens[0]; // command to server

                if ("logout".equalsIgnoreCase(cmd)) {
                    handleLogout();
                    break;
                } else if ("login".equalsIgnoreCase(cmd)) {
                    handleLogin(outputStream, tokens);
                } else if ("txtMsg".equalsIgnoreCase(cmd)) {
                    String[] msgTokens = StringUtils.split(line, null, 3);
                    handleTxtMessage(msgTokens);
                } else {
                    String msg = "unknown command: " + cmd + "\n";
                    outputStream.write(msg.getBytes());
                }

            }
        }

    }

    private void handleTxtMessage(String[] msgTokens) throws IOException {
        String sendTo = msgTokens[1];
        String msgBody = msgTokens[2];

        ArrayList<ServerWorker> workerList = server.getWorkerList();

        for (ServerWorker worker : workerList) {
            if (worker.getUsername().equalsIgnoreCase(sendTo)) {
                worker.send("txtMsg " + username + " " + msgBody + "\n");
            }
        }
    }

    private void handleLogin(OutputStream outputStream, String[] tokens) throws IOException {

        if (tokens.length == 3) {

            String username = tokens[1];
            String password = tokens[2];

            // Will be coonverted to database

            Hashtable<String, String> users = new Hashtable<>();
            users.put("guest", "guest");
            users.put("fatih", "fatih");
            users.put("talha", "talha");

            if ( (users.contains(username) && users.get(username).equals(password)) ) {
                String msg = "ok login: " + username + "\n";
                outputStream.write(msg.getBytes());

                this.username = username;

                System.out.println("ok login: " + username);

                ArrayList<ServerWorker> workerList = server.getWorkerList();

                for (ServerWorker worker : workerList) {
                    if (!worker.getUsername().equals(username)) {
                        String onlineList = "online " + worker.getUsername() + "\n";
                        send(onlineList);
                    }
                }

                String onlineMsg = "online " + username + "\n";
                for(ServerWorker worker : workerList) {
                    if (!username.equals(worker.getUsername())) {
                        worker.send(onlineMsg);
                    }
                }


            } else {
                String msg = "error login\n";
                outputStream.write(msg.getBytes());
                System.err.println("error login: " + username);
            }

        }

    }

    private void send(String msg) throws IOException {

        if ( username != null ) {
            outputStream.write(msg.getBytes());
        }
    }

    private void handleLogout() throws IOException {

        server.removeWorker(this);
        ArrayList<ServerWorker> workerList = server.getWorkerList();

        for (ServerWorker worker : workerList) {
            if (worker != null) {
                String msg = "offline " + username + "\n";
                worker.send(msg);
            }
        }

        clientSocket.close();

    }
}
