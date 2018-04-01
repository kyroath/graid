package com.graid.messages.client;

import com.graid.User;
import com.graid.handles.server.SLoginHandle;

public class CLoginMessage extends CMessage{

    User user;

    CLoginMessage(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public void handle() {

        SLoginHandle handle = new SLoginHandle(this);
        handle.handle();

    }
}
