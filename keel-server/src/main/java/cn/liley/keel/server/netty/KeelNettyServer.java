package cn.liley.keel.server.netty;

import org.springframework.beans.factory.annotation.Autowired;

import cn.liley.keel.server.KeelServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@ToString
public class KeelNettyServer implements KeelServer {

    private int port;

    private int backlog;

    @Autowired
    private ChildChannelHandler childChannelHandler;

    @Override
    public void run() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        log.info("server will run in the port：{}", port);
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, backlog)
                    .childHandler(childChannelHandler);
            //绑定端口，同步等待成功
            ChannelFuture f = bootstrap.bind(port).sync();
            //等待服务监听端口关闭
            f.channel().closeFuture().sync();
        } finally {
            //退出，释放线程资源
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

}
