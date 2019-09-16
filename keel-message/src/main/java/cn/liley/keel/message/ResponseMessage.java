package cn.liley.keel.message;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
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
