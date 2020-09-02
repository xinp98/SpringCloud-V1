package cn.tedu.sp11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class Sp11ZullApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sp11ZullApplication.class, args);
    }

}
