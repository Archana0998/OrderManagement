package order_managment_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("order_managment_system")
public class OrderManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderManagmentApplication.class, args);
		System.out.println("order ...");
	}

}
