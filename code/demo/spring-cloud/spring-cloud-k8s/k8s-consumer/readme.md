消费者
============
### Config
	config on git
###Hystrix
	断路器
###Ribbon
	负载均衡

### ribbon to provider 
curl http://localhost:8200/ribbon/hello

### feign to provider 
curl http://localhost:8200/feign/list

Feign是负责服务间内部调用消费，以及负责均衡的组件，但是和Eureka不一样，Feign没有Server这么一说，Feign本身就是个Client，它是可插拔的
