package cn.liley.keel.server.netty.handler;

import cn.liley.keel.message.BaseMessage;
import cn.liley.keel.message.LoginRequest;
import cn.liley.keel.message.LoginResponse;
import cn.liley.keel.message.MessageType;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginAuthResponseHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("receive a msg: {}", msg);
        if (msg instanceof BaseMessage) {
            BaseMessage baseMessage = (BaseMessage) msg;
            if (baseMessage.getType() == MessageType.LOGIN_REQ.getType()) {
                LoginRequest loginRequest = (LoginRequest) baseMessage;
                // todo 需要进行验证
                if (loginRequest.getAppId() == 1) {
                    LoginResponse loginResponse = new LoginResponse(loginRequest.getToken());
                    ctx.writeAndFlush(loginResponse);
                }
            } else {
                ctx.fireChannelRead(msg);
            }
        } else {
            ctx.fireChannelRead(msg);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelActive();
    }
}
