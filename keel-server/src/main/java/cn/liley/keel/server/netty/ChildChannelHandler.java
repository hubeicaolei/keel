package cn.liley.keel.server.netty;

import org.springframework.beans.factory.annotation.Autowired;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
    @Autowired
    private KeelServerHandler keelServerHandler;

    @Override
    public void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(keelServerHandler);
    }
}

