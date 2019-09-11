package cn.liley.keel.server.netty;

import org.springframework.beans.factory.annotation.Autowired;

import cn.liley.keel.server.netty.codec.MsgpackDecoder;
import cn.liley.keel.server.netty.codec.MsgpackEncoder;
import cn.liley.keel.server.netty.handler.HeartbeatResponseHandler;
import cn.liley.keel.server.netty.handler.LoginAuthResponseHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.timeout.ReadTimeoutHandler;

public class KeelChannelHandler extends ChannelInitializer<SocketChannel> {
    @Autowired
    private KeelServerHandler keelServerHandler;

    @Override
    public void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline()
                .addLast(new LengthFieldBasedFrameDecoder(1024 * 64, 0, 2, 0, 2))
                .addLast(new MsgpackDecoder()) // 解码器
                .addLast(new LengthFieldPrepender(2))
                .addLast(new MsgpackEncoder()) // 编码器
                .addLast(new ReadTimeoutHandler(10)) // 超时10s
                .addLast(new LoginAuthResponseHandler()) // 登录
                .addLast(new HeartbeatResponseHandler()); // 心跳
    }
}

