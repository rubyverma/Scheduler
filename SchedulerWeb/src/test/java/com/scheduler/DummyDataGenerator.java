package com.scheduler;

import org.springframework.stereotype.Component;

import com.scheduler.models.User;

@Component
public class DummyDataGenerator {

	public User createUser() {
		User u = new User();
		u.setId(1);
		u.setFirstname("John");
		u.setLastname("Doe");
		u.setEmail("john@gmail.com");
		return u;
	}
}
