package zseureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka服务注册
 */
@SpringBootApplication
@EnableEurekaServer
public class ZsEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZsEurekaApplication.class, args);
    }
}
