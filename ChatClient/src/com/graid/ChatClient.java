package com.graid;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ChatClient {

    private final String serverName;
    private final int serverPort;

    ArrayList<UserStatusListener> userStatusListeners = new ArrayList<>();
    ArrayList<MessageListener> messageListeners = new ArrayList<>();
    private Socket socket;
    private OutputStream serverOut;
    private InputStream serverIn;
    private BufferedReader bufferedReader;
    String username;

    ChatClient(String serverName, int serverPort) {
        this.serverName = serverName;
        this.serverPort = serverPort;
    }

    public static void main(String[] args) {

        ChatClient client = new ChatClient("localhost", 8818);
        client.addUserStatusListener(new UserStatusListener() {

            @Override
            public void online(String username) {
                System.out.println("ONLINE: " + username);
            }

            @Override
            public void offline(String username) {
                System.out.println("OFFLINE: " + username);
            }
        });

        client.addMessageListener(new MessageListener() {
            @Override
            public void onMessage(String fromUsername, String msgBody) {
                System.out.println(fromUsername + ": " + msgBody);
            }
        });

        if (!client.connect()) {
            System.err.println("Connection failed.");
        } else {
            System.out.println("Connection succesful.");

            try {

                if (client.login("guest", "guest")) {
                    System.out.println("Login succesful.");
                    System.out.println("You've logged in as: " + client.username);

                    client.msg("fatih", "Hello Fatih!");

                } else {
                    System.err.println("Login failed");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    private void msg(String sendTo, String msgBody) throws IOException {

        String cmd = "txtMsg " + sendTo + " " + msgBody + "\n";
        serverOut.write(cmd.getBytes());

    }

    private boolean login(String username, String password) throws IOException {

        String serverMsg = "login " + username + " " + password + "\n";
        serverOut.write(serverMsg.getBytes());

        String response = bufferedReader.readLine();
        System.out.println("Server response: " + response);

        if (("ok login: " + username).equals(response)) {
            this.username = username;
            startMessageReader();
            return true;
        } else {
            return false;
        }

    }

    private void logout() throws IOException {

        String serverMsg = "logout\n";
        serverOut.write(serverMsg.getBytes());

    }

    private void startMessageReader() {

        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    readMessageLoop();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }

    private void readMessageLoop() throws IOException {

        String line;
        while ( (line = bufferedReader.readLine()) != null ) {
            String tokens[] = StringUtils.split(line);
            if ( tokens != null && tokens.length > 0 ) {
                String cmd = tokens[0];
                if ("online".equals(cmd)) {
                    handleOnline(tokens);
                } else if ("offline".equals(cmd)) {
                    handleOffline(tokens);
                } else if ("txtMsg".equals(cmd)) {
                    String[] msgTokens = StringUtils.split(line, null, 3);
                    handleMessage(msgTokens);
                }
            }
        }

    }

    private void handleMessage(String[] msgTokens) {

        String username = msgTokens[1];
        String msgBody = msgTokens[2];

        for (MessageListener listener : messageListeners) {
            listener.onMessage(username, msgBody);
        }

    }

    private void handleOffline(String[] tokens) {

        String username = tokens[1];
        for (UserStatusListener listener : userStatusListeners) {
            listener.offline(username);
        }

    }

    private void handleOnline(String[] tokens) {

        String username = tokens[1];
        for (UserStatusListener listener : userStatusListeners) {
            listener.online(username);
        }

    }

    private boolean connect() {

        try {

            this.socket = new Socket(serverName, serverPort);
            System.out.println("Client port is: " + socket.getLocalPort());
            this.serverOut = socket.getOutputStream();
            this.serverIn = socket.getInputStream();
            this.bufferedReader = new BufferedReader(new InputStreamReader(serverIn));

            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    private void addUserStatusListener(UserStatusListener listener) {
        userStatusListeners.add(listener);
    }

    private void addMessageListener(MessageListener listener) {
        messageListeners.add(listener);
    }

    public void removeUserStatusListener(UserStatusListener listener) {
        userStatusListeners.remove(listener);
    }

    public void removeMessageListener(MessageListener listener) {
        messageListeners.remove(listener);
    }

}
