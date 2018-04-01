package com.graid.messages.server;

import com.graid.User;

public class SLoginMessage extends SMessage {

    User user;
    int returnCode;

    public SLoginMessage(User user, int returnCode) {

        this.user = user;
        this.returnCode = returnCode;

    }

    @Override
    public void handle() {

    }
}
