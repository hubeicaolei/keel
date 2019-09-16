package cn.liley.keel.client.netty.handler;


import java.util.concurrent.TimeUnit;

import cn.liley.keel.message.BaseMessage;
import cn.liley.keel.message.HeartbeatRequest;
import cn.liley.keel.message.MessageType;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.ScheduledFuture;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HeartbeatRequestHandler extends ChannelInboundHandlerAdapter {

    private volatile ScheduledFuture<?> heartbeat;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof BaseMessage) {
            BaseMessage keelMessage = (BaseMessage) msg;
            if (keelMessage.getType() == MessageType.LOGIN_RES.getType()) {
                heartbeat = ctx.executor()
                        .scheduleAtFixedRate(
                                new HeartbeatTask(ctx), 0, 5000, TimeUnit.MILLISECONDS);
                log.info("start to send a heartbeat every 5 seconds");
            } else if (keelMessage.getType() == MessageType.HEARTBEAT_RES.getType()) {
                log.info("receive a heatbeat response");
            } else {
                ctx.fireChannelRead(msg);
            }
        } else {
            ctx.fireChannelRead(msg);
        }
    }

    private class HeartbeatTask implements Runnable {
        private final ChannelHandlerContext ctx;
        public HeartbeatTask(final ChannelHandlerContext ctx) {
            this.ctx = ctx;
        }

        @Override
        public void run() {
            log.info("send a heartbeat!");
            HeartbeatRequest heartbeatRequest = new HeartbeatRequest();
            ctx.writeAndFlush(heartbeatRequest);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (null != heartbeat) {
            heartbeat.cancel(true);
            heartbeat = null;
        }
        ctx.fireExceptionCaught(cause);
    }
}
