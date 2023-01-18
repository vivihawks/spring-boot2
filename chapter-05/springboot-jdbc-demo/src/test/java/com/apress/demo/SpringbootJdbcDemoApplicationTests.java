package com.apress.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Siva
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJdbcDemoApplication.class)
public class SpringbootJdbcDemoApplicationTests
{

	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void findAllUsers()  {
		List<User> users = userRepository.findAll();
		assertNotNull(users);
		Iterator<User> itr = users.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().getName());
		}
		assertTrue(!users.isEmpty());
		
	}
	
	@Test
	public void findUserById()  {
		User user = userRepository.findUserById(1);
		
		System.out.print("Found user by id : ");
		System.out.println(user.getName());
		assertNotNull(user);
	}
	
	@Test
	public void createUser() {
		User user = new User(0, "Siva", "siva@gmail.com");
		User savedUser = userRepository.create(user);
		User newUser = userRepository.findUserById(savedUser.getId());
		assertEquals("Siva", newUser.getName());
		assertEquals("siva@gmail.com", newUser.getEmail());
	}
}
