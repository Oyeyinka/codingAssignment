package com.daofab.codingassignment;

import com.daofab.codingassignment.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CodingAssignmentApplicationTests {

	@Autowired
	IUserService userService;

	@Test
	void contextLoads() {

		var response = userService.getParent(0, 2);

		assertTrue(response.getSize() == 2);

	}

}
