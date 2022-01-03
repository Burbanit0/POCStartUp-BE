package com.telecom.pocstartup;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.telecom.pocstartup.domain.User;
import com.telecom.pocstartup.service.UserService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class userTest {
	@Autowired
	private UserService userService;
	
	@Test
	public void testFindAllUsers() {
		Collection<User> users = this.userService.findAllUsers();
		Assert.assertEquals(3,users.size());
	}
}

