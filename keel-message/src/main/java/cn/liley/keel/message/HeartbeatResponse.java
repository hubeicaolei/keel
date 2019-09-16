package cn.liley.keel.message;

import org.msgpack.annotation.Message;

import lombok.ToString;

@ToString
@Message
public class HeartbeatResponse extends BaseMessage {

    public HeartbeatResponse() {
        super(MessageType.HEARTBEAT_REQ);
    }
}
