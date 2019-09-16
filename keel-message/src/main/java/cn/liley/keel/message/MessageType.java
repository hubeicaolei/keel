package cn.liley.keel.message;

import org.msgpack.annotation.Message;

import lombok.Getter;

@Message
public enum MessageType {
    UNKNOWN(0, Object.class),        // 未知
    HEARTBEAT_REQ(1, HeartbeatRequest.class),  // 心跳请求
    HEARTBEAT_RES(2, HeartbeatResponse.class),  // 心跳响应
    LOGIN_REQ(3, LoginRequest.class),      // 登录请求
    LOGIN_RES(4, LoginResponse.class);      // 登录响应

    @Getter
    private int type;

    @Getter
    private Class messageClass;

    MessageType(int type, Class msgClass) {
        this.type = type;
        this.messageClass = msgClass;
    }

}
