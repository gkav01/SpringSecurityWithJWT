package com.kg.jwtdemo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kg.jwtdemo.entity.User;
import com.kg.jwtdemo.repository.UserRepository;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringSecurityJWtApplication {
	@Autowired
	private UserRepository userRepo ;
	
	@PostConstruct
	public void initUsers() {
	
		List<User> users = Stream.of(
				new User(101, "user101", "password1", "user101@gmail.com"),
				new User(102, "user102", "password2", "user102@gmail.com"),
				new User(103, "user103", "password3", "user103@gmail.com"),
				new User(104, "user104", "password4", "user104@gmail.com"),
				new User(105, "user105", "password5", "user105@gmail.com"))
				.collect(Collectors.toList());
		
		userRepo.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJWtApplication.class, args);
	}

}
