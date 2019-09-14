package cn.liley.keel.message;

public class HeartbeatResponse extends BaseMessage {

    public HeartbeatResponse() {
        super(MessageType.HEARTBEAT_REQ);
    }
}
