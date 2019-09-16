package cn.liley.keel.message;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@ToString
public class BaseMessage implements Serializable {

    private Integer type;

    public BaseMessage(MessageType type) {
        this.type = type.getType();
    }

    public BaseMessage() {
        this.type = MessageType.UNKNOWN.getType();
    }

}
