package cn.liley.keel.message;

public class HeartbeatRequest extends RequestMessage {

    public HeartbeatRequest(String token) {
        super(MessageType.HEARTBEAT_REQ, token);
    }
}
