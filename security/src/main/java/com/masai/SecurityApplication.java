package com.masai;

import java.util.List;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.masai.entity.User;
import com.masai.repository.UserRepository;

@SpringBootApplication
public class SecurityApplication {

	@Autowired
	UserRepository repository;
	
	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(
				new User(101,"suraj", "suraj123","s@gmail.com"),
				new User(102,"user1", "pwd1","user1@gmail.com"),
				new User(103,"user2", "pwd2","user2@gmail.com"),
				new User(104,"user3", "pwd3","user3@gmail.com"),
				new User(105,"user4", "pwd4","user4@gmail.com")
				).toList();
				
		repository.saveAll(users);
		
	}
	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
		
		
		
		
	}

}
