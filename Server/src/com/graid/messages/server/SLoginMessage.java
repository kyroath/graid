package com.graid.messages.server;

import com.graid.User;
import com.graid.handles.Handle;

import java.io.ObjectOutputStream;

public class SLoginMessage extends SMessage {

    private User user;
    private int returnCode;

    public SLoginMessage(User user, int returnCode) {

        this.user = user;
        this.returnCode = returnCode;

    }

    @Override
    public Handle handle() {
        return null;
    }

    public User getUser() {
        return user;
    }

    public int getReturnCode() {
        return returnCode;
    }
}
