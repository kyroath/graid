package com.graid.handles.server;

import com.graid.User;
import com.graid.messages.client.CLoginMessage;
import com.graid.messages.server.SLoginMessage;

public class SLoginHandle extends SHandle {

    private final CLoginMessage message;

    public SLoginHandle(CLoginMessage message) {
        this.message = message;
    }

    @Override
    public SLoginMessage handle() {

        int authenticateResult = authenticate();
        SLoginMessage serverMessage = new SLoginMessage(message.getUser(), authenticateResult);



        return serverMessage;

    }

    private int authenticate() {

        if (message.getUser().equals(new User("fatih", "fatih"))
                || message.getUser().equals(new User("talha", "talha"))) {
            return 1;
        }

        return -1;

    }
}
