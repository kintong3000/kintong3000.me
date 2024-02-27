package com.kintong.blogserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kintong.blogserver.entity.dto.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author kintong
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

}
