package cn.liley.keel.message.codec;

import org.msgpack.MessagePack;

import cn.liley.keel.message.BaseMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MsgpackEncoder extends MessageToByteEncoder<BaseMessage> {

    MessagePack messagePack = new MessagePack();

    @Override
    protected void encode(ChannelHandlerContext ctx, BaseMessage msg, ByteBuf out) throws Exception {

        byte[] bytes = messagePack.write(msg);
        out.writeBytes(bytes);
    }
}
