package cn.liley.keel.message;

public class LoginResponse extends KeelMessage {

    public LoginResponse(String token) {
        super(MessageType.LOGIN_RES);
        setToken(token);
    }
}
