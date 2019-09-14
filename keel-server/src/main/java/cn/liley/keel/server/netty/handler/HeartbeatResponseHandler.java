package cn.liley.keel.server.netty.handler;

import cn.liley.keel.message.KeelMessage;
import cn.liley.keel.message.MessageType;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class HeartbeatResponseHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        if (msg instanceof KeelMessage) {
            KeelMessage keelMessage = (KeelMessage) msg;
            if (keelMessage.getType() == MessageType.LOGIN_RES) {


            }
        } else {
            ctx.fireChannelRead(msg);
        }
    }


}
