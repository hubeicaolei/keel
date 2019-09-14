package cn.liley.keel.message;

import java.io.Serializable;


public class RequestMessage extends KeelMessage {

    public RequestMessage(MessageType type, String token) {
        super(type, token);
    }

    public RequestMessage() {
        super();
    }

}
