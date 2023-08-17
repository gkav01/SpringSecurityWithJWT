package com.kg.jwtdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kg.jwtdemo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserName(String username);

}
