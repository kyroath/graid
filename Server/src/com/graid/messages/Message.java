package com.graid.messages;

import com.graid.handles.Handle;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class Message implements Serializable {

    public abstract Handle handle();
}
