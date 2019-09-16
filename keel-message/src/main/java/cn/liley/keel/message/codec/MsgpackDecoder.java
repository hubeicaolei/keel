package cn.liley.keel.message.codec;

import java.util.List;

import org.msgpack.MessagePack;
import org.msgpack.type.ArrayValue;
import org.msgpack.type.Value;

import cn.liley.keel.message.MessageFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

public class MsgpackDecoder extends MessageToMessageDecoder<ByteBuf> {

    MessagePack messagePack = new MessagePack();

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        final byte[] array;
        final int length = msg.readableBytes();
        array = new byte[length];
        msg.getBytes(msg.readerIndex(), array, 0, length);
        Object item = null;
        Value value = messagePack.read(array);
        if (value instanceof ArrayValue) {
            item = messagePack.convert(value, MessageFactory.getMessageClass(((ArrayValue) value).get(0)
                    .asIntegerValue().intValue()));

        }
        if (null != item) {
            out.add(item);
        } else {
            out.add(value);
        }
    }
}
