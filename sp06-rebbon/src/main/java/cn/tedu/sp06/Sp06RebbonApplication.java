package cn.tedu.sp06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
@EnableDiscoveryClient //eureka
@EnableCircuitBreaker    //hystrix
@SpringBootApplication
public class Sp06RebbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sp06RebbonApplication.class, args);
    }

    @LoadBalanced //rebbon 负载均衡
    @Bean
    public RestTemplate restTemplate(){
        SimpleClientHttpRequestFactory f = new SimpleClientHttpRequestFactory();
        f.setConnectTimeout(1000);  //超过这个时间将会重试
        f.setReadTimeout(1000);
        //RestTemplate 中默认的 Factory 实例中，两个超时属性默认是 -1，
        //未启用超时，也不会触发重试
        //return new RestTemplate();
        return new RestTemplate();
    }
}
