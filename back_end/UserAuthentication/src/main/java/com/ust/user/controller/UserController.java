package com.ust.user.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.user.entity.Login;
import com.ust.user.entity.User;
import com.ust.user.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")

public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/user/register")

	public ResponseEntity<?> registerUser(@RequestBody User user) throws Exception
	{
		System.out.println(user.getUsername());
		//System.out.println(user.getName());
		System.out.println(user.getEmailaddress());
		System.out.println(user.getPassword());
		System.out.println(user.getConfirmpassword());

		String tempUsername=user.getUsername();
		if(tempUsername != null && tempUsername!="") {
			User userobj = userService.getUserByUsername(tempUsername);
			if(userobj != null ) {
				throw new Exception("user with "+tempUsername+" already exists");
			}
		}
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());

		User user2 = new User(user.getName(), user.getEmailaddress(), user.getUsername(), encodedPassword, encodedPassword);


		User registerUser = userService.registerUser(user2);
		return new ResponseEntity<User>(registerUser, HttpStatus.OK);
	}

	@PostMapping("/users/login")
	public ResponseEntity<?> logIn(@RequestBody Login login)
	{
		System.out.println(login.getUsername());
		System.out.println(login.getPassword());

		User user1 = userService.getUserByUsername(login.getUsername());


		Boolean b = BCrypt.checkpw(login.getPassword(), user1.getPassword());
		if(b==true) {


			String token = Jwts.builder().setId(user1.getUsername()).setIssuedAt(new Date(0))
					.signWith(SignatureAlgorithm.HS256, "usersecretkey").compact();

			Map<String, String> tokenMap = new HashMap<String, String>();
			tokenMap.put("token", token);
			tokenMap.put("message", "User Successfully logged in");
			ResponseEntity<Map<String, String>> response = new ResponseEntity<Map<String, String>>(tokenMap, HttpStatus.OK);

			return response;
		}
		else {

			return new ResponseEntity<User>( HttpStatus.NOT_FOUND);
		}

	}

}



