package uz.savdo.ombor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class OmborApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmborApplication.class, args);
	}

}
