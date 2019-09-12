package cn.liley.keel.client.netty;

import cn.liley.keel.client.KeelClient;

import cn.liley.keel.client.netty.handler.HeartbeatRequestHandler;
import cn.liley.keel.client.netty.handler.LoginAuthRequestHandler;
import cn.liley.keel.message.codec.MsgpackDecoder;
import cn.liley.keel.message.codec.MsgpackEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.timeout.ReadTimeoutHandler;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@ToString
public class KeelNettyClient implements KeelClient {

    private int port;

    private int backlog;

    private String host;

    private EventLoopGroup group = new NioEventLoopGroup();

    @Override
    public void run() throws Exception {
        connect(host, port);

    }

    private void connect(String host, int port) throws Exception {
        Bootstrap client = new Bootstrap();
        client.group(group).channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline()
                                .addLast(new LengthFieldBasedFrameDecoder(1024 * 64, 0, 2, 0, 2))
                                .addLast(new MsgpackDecoder()) // 解码器
                                .addLast(new LengthFieldPrepender(2))
                                .addLast(new MsgpackEncoder()) // 编码器
                                .addLast(new ReadTimeoutHandler(10)) // 超时10s
                                .addLast(new LoginAuthRequestHandler()) // 登录
                                .addLast(new HeartbeatRequestHandler()); // 心跳
                    }
                });
    }
}
