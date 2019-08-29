package cn.liley.keel.server.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.liley.keel.server.KeelServer;
import cn.liley.keel.server.netty.KeelNettyServer;

@Configuration
@EnableConfigurationProperties(KeelProperties.class)
public class KeelServerConfiguation {

    @Autowired
    KeelProperties keelProperties;

    @Bean
    public KeelServer keelServer() {
        KeelNettyServer keelServer = new KeelNettyServer();
        keelServer.setPort(keelProperties.getPort());
        keelServer.setBacklog(keelProperties.getBacklog());
        return keelServer;
    }
}
