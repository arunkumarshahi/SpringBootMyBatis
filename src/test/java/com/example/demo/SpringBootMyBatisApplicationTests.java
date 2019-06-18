package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.User;
import com.example.demo.mappers.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMyBatisApplicationTests {

	@Autowired
	private UserMapper userMapper;

//	@Test
//	public void contextLoads() {
//	}
	 @Test
	    public void findUserById()  {
	        User user = userMapper.findUserById(1);
	        System.out.println("findUserById user data before insert "+user);
	        assertNotNull(user);
	    }

	@Test
	public void createUser() {
		User user = new User(0, "george", "george@gmail.com");
		System.out.println("new user data before insert ");
		userMapper.insertUser(user);
		System.out.println("new user after before insert ");
		User newUser = userMapper.findUserById(user.getId());
		System.out.println("new user data "+newUser);
		assertEquals("george", newUser.getName());
		assertEquals("george@gmail.com", newUser.getEmail());
	}
}
