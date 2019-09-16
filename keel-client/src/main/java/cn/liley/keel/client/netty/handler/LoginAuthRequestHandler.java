package cn.liley.keel.client.netty.handler;

import cn.liley.keel.message.BaseMessage;
import cn.liley.keel.message.LoginRequest;
import cn.liley.keel.message.LoginResponse;
import cn.liley.keel.message.MessageType;
import cn.liley.keel.message.RequestMessage;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginAuthRequestHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("send a login request");
        ctx.writeAndFlush(buildLoginRequest());
    }

    private RequestMessage buildLoginRequest() {
        // todo 创建一个login request
        return new LoginRequest(1, "cccc");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("receive a msg:{}", msg);
        if (msg instanceof BaseMessage) {
            BaseMessage baseMessage = (BaseMessage) msg;
            if (baseMessage.getType() == MessageType.LOGIN_RES.getType()) {
                LoginResponse loginResponse = (LoginResponse) baseMessage;
                if (loginResponse.getErrCode() != 0) {
                    ctx.close();
                } else {
                    ctx.fireChannelRead(msg);
                }
            } else {
                ctx.fireChannelRead(msg);
            }
        } else {
            ctx.fireChannelRead(msg);
        }
    }


}
