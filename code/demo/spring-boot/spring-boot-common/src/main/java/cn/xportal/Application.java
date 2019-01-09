package cn.xportal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("cn.xportal.mapper")
@ServletComponentScan("cn.xportal.web.filter")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
