package org.example.eleme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.example.eleme.repository")
public class ElemeApplication {
	public static void main(String[] args) {
		SpringApplication.run(ElemeApplication.class, args);
	}
}
