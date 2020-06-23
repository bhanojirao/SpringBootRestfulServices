package com.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.model.User;
import com.myapp.service.LoginService;

@RestController
@RequestMapping("/user")
public class LoginController {
	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody User user) {
 
		String status;
		try {
			status=loginService.register(user);
			
			return new ResponseEntity<String>(status,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			status="something went wrong...!";
			return new ResponseEntity<String>(status, HttpStatus.OK);
		}
	}
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public ResponseEntity<User>login(@RequestBody User user){
		
		User u=loginService.login(user);
		return null;
		
	}

}
