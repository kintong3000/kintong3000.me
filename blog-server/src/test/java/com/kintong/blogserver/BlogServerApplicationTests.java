package com.kintong.blogserver;

import com.kintong.blogserver.commons.ultils.ApiResult;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogServerApplicationTests {

	@Test
	void contextLoads() {
		String text = ApiResult.success().toJsonString();
	}

}
