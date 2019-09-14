package cn.liley.keel.message;

/**
 * 登录请求， 带上appid和token， token是通过加密算法计算出来的加密字串
 *
 * @author caolei
 * @blame caolei
 */
public class LoginRequest extends KeelMessage {

    private long appId;

    public LoginRequest(long appId, String token) {
        super(MessageType.LOGIN_REQ);
        setToken(token);
        this.appId = appId;
    }
}
