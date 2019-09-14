package cn.liley.keel.message;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;

@Data
public class BaseMessage implements Serializable {

    private MessageType type;

    public BaseMessage(MessageType type) {
        this.type = type;
    }

    public BaseMessage() {
        this.type = MessageType.UNKNOWN;
    }

}
