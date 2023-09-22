package pl.com.coders.libria1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "pl.com.coders.libria1")
public class Libria1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Libria1Application.class, args);
	}

}
