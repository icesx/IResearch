package com.trgis.sb2sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableDiscoveryClient
@SpringBootApplication
@EnableZuulProxy
@RefreshScope
public class Sb2scZuulApplication {
	public static void main(String[] args) {
		SpringApplication.run(Sb2scZuulApplication.class, args);
	}
}
