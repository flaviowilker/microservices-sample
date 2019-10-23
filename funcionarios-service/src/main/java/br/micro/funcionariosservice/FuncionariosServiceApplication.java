package br.micro.funcionariosservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FuncionariosServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuncionariosServiceApplication.class, args);
	}
}
