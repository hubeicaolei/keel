package cn.liley.keel.client.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.liley.keel.client.KeelClient;
import cn.liley.keel.client.netty.KeelNettyClient;
import cn.liley.keel.client.netty.handler.HeartbeatRequestHandler;

@Configuration
@EnableConfigurationProperties(KeelProperties.class)
public class KeelClientConfiguation {

    @Autowired
    KeelProperties keelProperties;

    @Bean
    public KeelClient keelClient() {
        KeelNettyClient keelNettyClient = new KeelNettyClient();
        keelNettyClient.setPort(keelProperties.getPort());
        keelNettyClient.setBacklog(keelProperties.getBacklog());
        keelNettyClient.setHost(keelProperties.getHost());
        return keelNettyClient;
    }
}
