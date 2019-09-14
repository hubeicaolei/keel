package cn.liley.keel.message;

public enum MessageType {
    UNKNOWN,        // 未知
    HEARTBEAT_REQ,  // 心跳请求
    HEARTBEAT_RES,  // 心跳响应
    LOGIN_REQ,      // 登录请求
    LOGIN_RES;      // 登录响应
}
