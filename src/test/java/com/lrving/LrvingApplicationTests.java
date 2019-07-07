package com.lrving;

import com.lrving.entity.User;
import com.lrving.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LrvingApplicationTests {


	@Autowired
	private UserService userService;
	@Test
	public void contextLoads() {

		User userById = userService.getUserById(1);
		System.out.println(userById.getName());
	/*	User user = new User();
		user.setName("k123");
		int i = userService.addUser(user);
		System.out.println(i);
*/
	}

}
