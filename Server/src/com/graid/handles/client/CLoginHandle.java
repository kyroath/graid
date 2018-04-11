package com.graid.handles.client;

import com.graid.User;
import com.graid.handles.Handle;
import com.graid.messages.Message;
import com.graid.messages.client.CLoginMessage;
import com.graid.messages.server.SLoginMessage;

public class CLoginHandle extends Handle{

    User user;

    public CLoginHandle(String username, String password) {

        user = new User(username, password);

    }

    @Override
    public Message handle() {

        return new CLoginMessage(user);

    }
}
