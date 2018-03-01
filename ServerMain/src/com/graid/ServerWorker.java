package com.graid;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Hashtable;

import com.sun.istack.internal.NotNull;
import org.apache.commons.lang3.StringUtils;

public class ServerWorker extends Thread {

    private final Server server;
    private final Socket clientSocket;
    private String username = null;

    private Hashtable<String, ArrayList<String>> voteQuestions = new Hashtable<>();

    private OutputStream outputStream;

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

        InputStream inputStream = clientSocket.getInputStream();
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
                } else if ("vote".equalsIgnoreCase(cmd)) {
                    handleVote(tokens);
                } else {
                    String msg = "unknown command: " + cmd + "\n";
                    outputStream.write(msg.getBytes());
                }

            }
        }

    }

    private void handleVote(String[] tokens) {

        if (username == null || username == "") {
            try {
                outputStream.write(("must be logged in to use command: vote\n").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            String cmd = tokens[1];

            if ("create".equalsIgnoreCase(cmd)) {
                handleVoteCreate(tokens);
            } else if ("answer".equalsIgnoreCase(cmd)) {
                handleVoteAnswer(tokens);
            } else if ("get".equalsIgnoreCase(cmd)) {
                handleVoteGet(tokens);
            } else if ("delete".equalsIgnoreCase(cmd)) {
                handleVoteDelete(tokens);
            }
        }
    }

    private void handleVoteDelete(@NotNull String[] tokens) {

        if (tokens != null && tokens.length == 3) {

            String question = tokens[2];
            voteQuestions.remove(question);

            try {
                outputStream.write("ok vote delete\n".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void handleVoteGet(@NotNull String[] tokens) {


        if (tokens != null && tokens.length == 3) {

            String question = tokens[2];
            StringBuilder serverReply = new StringBuilder("vote get " + tokens[2]);

            if (!voteQuestions.containsKey(question)) {
                try {
                    outputStream.write(("error vote get " + tokens[2] + " 1\n").getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                for (String voteAnswer : voteQuestions.get(question)) {

                    serverReply.append(" ").append(voteAnswer);

                }

                if (serverReply.length() > ("vote get " + tokens[2]).length()) {

                    try {
                        outputStream.write((serverReply + "\n").getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (!(serverReply.length() > ("vote get " + tokens[2]).length())) {
                    try {
                        outputStream.write("error vote get 0\n".getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void handleVoteAnswer(@NotNull String[] tokens) {

        if (tokens != null && tokens.length == 4) {

            String question = tokens[2];
            String answer = tokens[3];

            if (!voteQuestions.containsKey(question)) {
                try {
                    outputStream.write(("error vote answer 1\n").getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {

                if (question != null && question.length() > 0) {

                    for (int i = 0; i < voteQuestions.get(question).size(); i++) {

                        String questionAnswer = voteQuestions.get(question).get(i);
                        int hashIndex = questionAnswer.lastIndexOf("#");

                        if (questionAnswer.substring(0, hashIndex).equals(answer)) {

                            //vote count increased by one
                            int voteCount = Integer.parseInt(questionAnswer.substring(hashIndex + 1)) + 1;

                            //get the existing arraylist of answers to the given question
                            ArrayList<String> tempList = new ArrayList<>(voteQuestions.get(question));

                            //change the temporary list to increase the vote count
                            tempList.set(i, tempList.get(i).substring(0, hashIndex) + "#" + voteCount);

                            // put back the temporary list to the original location of answers
                            voteQuestions.put(question, tempList);

                            try {
                                outputStream.write(("ok vote " + answer + "\n").getBytes());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            break;

                        }
                    }

                } else if (question == null) {
                    try {
                        outputStream.write(("error vote " + answer + " 0\n").getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (question.length() == 0) {
                    try {
                        outputStream.write(("error vote " + answer + " 1\n").getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void handleVoteCreate(@NotNull String[] tokens) {

        if (tokens != null && tokens.length > 3) {

            String question = tokens[2] + "+" + username;
            voteQuestions.put(question, new ArrayList<>());

            for (int i = 3; i < tokens.length; i++) {
                if (tokens[i] != null && voteQuestions.get(question) != null) {
                    voteQuestions.get(question).add(tokens[i].concat("#0"));
                } else {
                    throw new NullPointerException();
                }
            }

            try {

                if (voteQuestions.get(question).size() > 0) {
                    outputStream.write("ok vote create\n".getBytes());
                } else {
                    outputStream.write("error vote create 0\n".getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (tokens == null) {
            throw new NullPointerException();
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
