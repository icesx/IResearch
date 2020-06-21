package cn.xportal.sc.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrix
@SpringBootApplication
public class ConsumerApplication {
	private static final Logger logger = LoggerFactory.getLogger(ConsumerApplication.class);

	@Autowired
	private RestTemplateBuilder builder;

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return builder.build();
	}

	public static void main(String[] args) {
		logger.info("start Consumer..."); 
		SpringApplication.run(ConsumerApplication.class, args);
	}
}
