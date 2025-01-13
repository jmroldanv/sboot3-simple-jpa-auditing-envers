package com.demo.db;

import com.demo.db.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Slf4j
@EnableJpaAuditing(auditorAwareRef = "customUserAuditorAware")
@SpringBootApplication
public class App implements CommandLineRunner {

	private CustomerService customerService;

	public App(CustomerService customerService) {
		this.customerService = customerService;
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("running ...");

		customerService.getAll().forEach(customer -> log.info("Customer: {}", customer));

		//obtenemos el último registro y extraemos el id, le sumamos uno y nos inventamos un nombre para llamar a customerService.create
		//y pasarle esos dos parámetros
		//generamos una cadena aleatoria para el nombre
		//En caso de no obtener ningún registro el id será 1

		//Cada vez que creamos un nuevo Customer los campos de auditoría se rellenan automáticamente.
		//El usuario no lo tenemos ya que la seguridad no está activada (no spring security, login, etc)
		//Long id = customerService.getAll().stream().mapToLong(Customer::getId).max().orElse(0) + 1;
		//String name = "Customer" + id;

		//String name = "Customer" + (customerService.getAll().stream().mapToLong(Customer::getId).max().orElse(0) + 1);
		//customerService.create(new Customer(name));
	}
}
