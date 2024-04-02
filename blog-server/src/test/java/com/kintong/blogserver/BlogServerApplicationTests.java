package com.kintong.blogserver;

import com.kintong.blogserver.mapper.ArticleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogServerApplicationTests {

//	@Test
//	void contextLoads() {
//		System.out.println(new BCryptPasswordEncoder().encode("123456"));
//	}


	@Autowired
	ArticleMapper articleMapper;

	@Test
	public void testservice(){

	}

}
