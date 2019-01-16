package cn.xportal.sc.consumer.controller;

import java.io.IOException;
import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import reactor.core.publisher.Mono;

@RestController
public class RibbonController {
	private static final String PROVIDER = "provider";

	private static final Logger logger = LoggerFactory.getLogger(RibbonController.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@GetMapping("/ribbon/{wd}")
	@HystrixCommand(fallbackMethod = "fallbackMethod")
	public Mono<String> sayHelloWorld(@PathVariable("wd") String parm) {
		String res = this.restTemplate.getForObject("http://"+PROVIDER+"/test/" + parm, String.class);
		return Mono.just(res);
	}

	@GetMapping("/ribbon/lb")
	@HystrixCommand(fallbackMethod = "fallbackMethod")
	public Mono<String> sayHello() throws IOException {
		ServiceInstance instance = loadBalancerClient.choose(PROVIDER);
		URI storesUri = URI.create(String.format("http://%s:%s", instance.getHost(), instance.getPort()));
		logger.info(storesUri.toString());
		return Mono.just("");
	}

	public Mono<String> fallbackMethod(@PathVariable("wd") String parm) {
		return Mono.just("fallback");
	}
}
