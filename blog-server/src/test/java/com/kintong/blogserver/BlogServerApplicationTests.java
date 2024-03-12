package com.kintong.blogserver;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kintong.blogserver.commons.ultils.ApiResult;
import com.kintong.blogserver.entity.dto.Article;
import com.kintong.blogserver.entity.vo.PageVo;
import com.kintong.blogserver.mapper.ArticleMapper;
import com.kintong.blogserver.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
