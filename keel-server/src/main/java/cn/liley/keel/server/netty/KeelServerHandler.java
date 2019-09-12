package cn.liley.keel.server.netty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

@ChannelHandler.Sharable
@Component
public class KeelServerHandler extends ChannelHandlerAdapter {

    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        try {
            ByteBuf in = (ByteBuf) msg;
            System.out.println("传输内容是");
            System.out.println(in.toString(CharsetUtil.UTF_8));
            //这里调用service服务
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 出现异常就关闭
        cause.printStackTrace();
        ctx.close();
    }
}

