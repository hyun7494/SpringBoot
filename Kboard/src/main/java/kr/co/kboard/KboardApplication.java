package kr.co.kboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class KboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(KboardApplication.class, args);
	}
	
	@GetMapping({"/", "/index"})
	public String index() {
		return "/user/login";
	}

}
