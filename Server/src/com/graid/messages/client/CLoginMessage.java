package com.graid.messages.client;

import com.graid.User;
import com.graid.handles.Handle;
import com.graid.handles.server.SLoginHandle;

public class CLoginMessage extends CMessage{

    private final User user;

    public CLoginMessage(User user) {
        this.user = user;
    }

    @Override
    public Handle handle() {
        return new SLoginHandle(this);
    }

    public User getUser() {
        return user;
    }
}
