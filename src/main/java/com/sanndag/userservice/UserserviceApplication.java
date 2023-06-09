package com.sanndag.userservice;

import com.sanndag.userservice.domain.Role;
import com.sanndag.userservice.domain.User;
import com.sanndag.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

    @Bean
	CommandLineRunner run(UserService userService){
		return args ->{
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROL_SUPER_ADMIN"));

			userService.saveUser(new User(null, "John Crook", "john", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Bruce Mirn", "bmirn", "5678", new ArrayList<>()));
			userService.saveUser(new User(null, "Jennifer Labrok", "jenni_80", "9101", new ArrayList<>()));
			userService.saveUser(new User(null, "Carl Brown", "cb88", "1121", new ArrayList<>()));

			userService.addRoleToUser("john", "ROLE_USER");
			userService.addRoleToUser("john", "ROLE_MANAGER");
			userService.addRoleToUser("bmirn", "ROLE_MANAGER");
			userService.addRoleToUser("jenni_80", "ROLE_ADMIN");
			userService.addRoleToUser("cb88", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("cb88", "ROLE_ADMIN");
			userService.addRoleToUser("cb88", "ROLE_USER");
		};


	}

}
