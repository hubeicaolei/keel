package cn.liley.keel.server.netty.codec;

import org.msgpack.MessagePack;

import cn.liley.keel.server.message.KeelMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MsgpackEncoder extends MessageToByteEncoder<KeelMessage> {

    MessagePack messagePack = new MessagePack();

    @Override
    protected void encode(ChannelHandlerContext ctx, KeelMessage msg, ByteBuf out) throws Exception {

        byte[] bytes = messagePack.write(msg);
        out.writeBytes(bytes);
    }
}
