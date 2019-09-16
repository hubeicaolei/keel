package cn.liley.keel.message;

import lombok.ToString;

@ToString
public class RequestMessage extends KeelMessage {

    public RequestMessage(MessageType type, String token) {
        super(type, token);
    }

    public RequestMessage() {
        super();
    }

}
