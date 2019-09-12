package cn.liley.keel.client.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix = "keel", ignoreUnknownFields = true)
@Data
public class KeelProperties {

    private int port;
    private int backlog;
    private String host;

}
