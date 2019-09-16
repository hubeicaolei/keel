package cn.liley.keel.message;

import org.msgpack.annotation.Message;

import lombok.ToString;

@ToString
@Message
public class HeartbeatRequest extends BaseMessage {

    public HeartbeatRequest() {
        super(MessageType.HEARTBEAT_REQ);
    }
}
