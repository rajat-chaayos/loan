package com.rapipay.loan;

import com.rapipay.loan.Products.Products;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class LoanApplication {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	public RedisTemplate<String, Products> redisTemplate() {
		RedisTemplate<String, Products> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
	public static void main(String[] args) {
		SpringApplication.run(LoanApplication.class, args);
	}

}
