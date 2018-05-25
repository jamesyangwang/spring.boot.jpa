package com.example.demo.runner;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.dao.UserDaoImpl;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;

@Component
public class UserCommandLineRunner implements CommandLineRunner {
	
	private static Logger log = LoggerFactory.getLogger(UserCommandLineRunner.class);

	@Autowired
	private UserDaoImpl userDao;
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public void run(String... args) throws Exception {
		User user = new User("Jack", "Admin");
		long insert = userDao.insert(user);
		log.info("New user is created: #" + insert + " - " + user);

		user = new User("Jill", "User");
		User newUser = userRepo.save(user);
		log.info("New user is created: " + newUser);
		
		Optional<User> userIdOne = userRepo.findById(1l);
		log.info("User is retrived: " + userIdOne.get());
		
		List<User> users = userRepo.findAll();
		log.info("All users: " + users);
	}
}
