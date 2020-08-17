package dev.four.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan("dev.four")
@EntityScan("dev.four.entities")
@EnableJpaRepositories("dev.four.repositories")
public class SafeConsultationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafeConsultationApplication.class, args);
	}

}
