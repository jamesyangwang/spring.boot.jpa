package com.example.demo.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.dao.UserDaoImpl;
import com.example.demo.entity.User;

@Component
public class UserCommandLineRunner implements CommandLineRunner {
	
	private static Logger log = LoggerFactory.getLogger(UserCommandLineRunner.class);

	@Autowired
	private UserDaoImpl userDao;
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User("Jack", "Admin");
		long insert = userDao.insert(user);
		log.info("New user is created: #" + insert + " - " + user);
	}

}
