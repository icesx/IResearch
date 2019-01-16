package cn.xportal.sc.provider.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("test")
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@GetMapping("{msg}")
	public Mono<String> sayHelloWorld(@PathVariable("msg") String msg) {
		logger.info("come on {}", msg);
		return Mono.just("sc-provider receive : " + msg);
	}

	@GetMapping("list")
	public Flux<Integer> list() {
		List<Integer> list = new ArrayList<>();
		list.add(8);
		list.add(22);
		list.add(75);
		list.add(93);
		Flux<Integer> userFlux = Flux.fromIterable(list);
		return userFlux;
	}
}
