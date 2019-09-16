package cn.liley.keel.message;

public class MessageFactory {

    public static Class getMessageClass(int type) {
        for (MessageType messageType : MessageType.values()) {
            if (messageType.getType() == type) {
                return messageType.getMessageClass();
            }
        }
        return null;
    }
}
