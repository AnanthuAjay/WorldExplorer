package com.ust.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.user.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public List<User> findByUsernameAndPassword(String username, String password);
	public User findByUsername(String username);
	

}
