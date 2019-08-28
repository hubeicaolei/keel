package cn.liley.keel.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KeelServerApplication implements CommandLineRunner {

    @Autowired
    private KeelServer keelServer;

    public static void main(String[] args) {
        SpringApplication.run(KeelServerApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        keelServer.run();
    }
}
