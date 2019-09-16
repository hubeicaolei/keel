package cn.liley.keel.server.netty.handler;


import cn.liley.keel.message.BaseMessage;
import cn.liley.keel.message.HeartbeatResponse;
import cn.liley.keel.message.MessageType;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HeartbeatResponseHandler extends ChannelInboundHandlerAdapter {

    HeartbeatResponse heartbeat = new HeartbeatResponse();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("receive a msg, {}", msg);
        if (msg instanceof BaseMessage) {
            BaseMessage keelMessage = (BaseMessage) msg;
            if (keelMessage.getType() == MessageType.HEARTBEAT_REQ.getType()) {
                log.info("receive a heartbeat request");
                ctx.writeAndFlush(heartbeat );
            } else {
                ctx.fireChannelRead(msg);
            }
        } else {
            ctx.fireChannelRead(msg);
        }
    }


}
