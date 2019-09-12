package cn.liley.keel.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KeelClientApplication implements CommandLineRunner {

    @Autowired
    private KeelClient keelClient;

    public static void main(String[] args) {
        SpringApplication.run(KeelClientApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        keelClient.run();
    }
}
