package com.graid.handles.server;

import com.graid.User;
import com.graid.messages.client.CLoginMessage;
import com.graid.messages.server.SLoginMessage;

import java.io.ObjectOutputStream;

public class SLoginHandle extends SHandle {

    User user;

    public SLoginHandle(CLoginMessage message) {
        this.user = message.getUser();
    }

    @Override
    public void handle() {

        int returnCode = authenticate(user);
        SLoginMessage returnMessage = new SLoginMessage(user, returnCode);
        returnMessage.send();

    }

    private int authenticate(User user) {

        return 0;

    }
}
