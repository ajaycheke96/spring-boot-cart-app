package com.dtech.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

//	@Autowired
//	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@PostConstruct
//	public void saveInitUsers() {
//		List<User> users = List.of(new User(null, "Ajay", "ajaycheke123@gmail.com", "oooooo"),
//				new User(null, "Vikas", "vikas3@gmail.com", "oooooo"));
//		System.out.println(userRepository.saveAll(users));
//	}

}
