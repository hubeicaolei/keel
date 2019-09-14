package cn.liley.keel.message;

import lombok.Data;

@Data
public class KeelMessage extends BaseMessage {

    private String token;

    public KeelMessage(MessageType type, String token) {
        super(type);
        setToken(token);
    }

    public KeelMessage() {
        super();
        setToken("");
    }

}
