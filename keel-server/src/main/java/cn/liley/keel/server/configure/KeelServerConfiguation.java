package cn.liley.keel.server.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.liley.keel.server.KeelServer;

@Configuration
public class KeelServerConfiguation {

    @Bean
    public KeelServer keelServer() {
        KeelServer keelServer = new KeelServer();
        return keelServer;
    }
}
