package cn.liley.keel.message;

import org.msgpack.annotation.Message;

import lombok.ToString;

@ToString
@Message
public class LoginResponse extends ResponseMessage {

    public LoginResponse(String token) {
        super(MessageType.LOGIN_RES, token);
        setToken(token);
    }

    public LoginResponse() {
        super();
    }
}
