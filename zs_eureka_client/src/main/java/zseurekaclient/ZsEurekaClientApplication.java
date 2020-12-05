package zseurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * eureka 客户端
 */
@SpringBootApplication
@EnableEurekaClient
public class ZsEurekaClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZsEurekaClientApplication.class, args);
    }

    @Bean
    @LoadBalanced //负载均衡注解
    public RestTemplate  restTemplate(){
       return  new RestTemplate();
    }
}
