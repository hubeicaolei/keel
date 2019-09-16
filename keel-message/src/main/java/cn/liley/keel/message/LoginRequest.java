package cn.liley.keel.message;

import org.msgpack.annotation.Message;

import lombok.Data;
import lombok.ToString;

/**
 * 登录请求， 带上appid和token， token是通过加密算法计算出来的加密字串
 *
 * @author caolei
 * @blame caolei
 */
@ToString
@Data
@Message
public class LoginRequest extends RequestMessage {

    private Long appId;

    public LoginRequest(long appId, String token) {
        super(MessageType.LOGIN_REQ, token);
        this.appId = appId;
    }
    public LoginRequest() {
        super();
    }
}
