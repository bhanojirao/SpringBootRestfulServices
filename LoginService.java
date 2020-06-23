package com.myapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.model.User;
import com.myapp.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository loginRepo;

	public String register(User user) {
		// TODO Auto-generated method stub
		User u=loginRepo.save(user);
		if(u!=null) {
			return"User register successfully...!";
		}else
		return "user not Register..!";
	}

	public User login(User user) {
		// TODO Auto-generated method stub
		Optional<User> user1=loginRepo.findById(user.getId());
		
	
		return null;
	}

}
