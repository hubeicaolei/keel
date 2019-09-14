package cn.liley.keel.message;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResponseMessage extends KeelMessage {

    private long errCode;

    private String errMsg;

    public ResponseMessage(MessageType type, String token) {
        super(type, token);
        setErrCode(0);
        setErrMsg("");
    }

    public ResponseMessage() {
        super();
        setErrCode(0);
        setErrMsg("");
    }

}
