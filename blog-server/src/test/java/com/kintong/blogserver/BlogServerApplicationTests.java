package com.kintong.blogserver;

import com.kintong.blogserver.commons.ultils.ApiResult;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class BlogServerApplicationTests {

	@Test
	void contextLoads() {
		System.out.println(new BCryptPasswordEncoder().encode("123456"));
	}

}
