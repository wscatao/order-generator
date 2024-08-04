package br.com.btgpactual.ordergenerator;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class OrderGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderGeneratorApplication.class, args);
	}
}
