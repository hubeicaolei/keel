package cn.liley.keel.server.netty;

import org.springframework.beans.factory.annotation.Autowired;

import cn.liley.keel.server.netty.handler.LoginAuthResponseHander;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;

public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
    @Autowired
    private KeelServerHandler keelServerHandler;

    @Override
    public void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new ReadTimeoutHandler(60))
                .addLast(new LoginAuthResponseHander())
                .addLast(keelServerHandler);
    }
}

