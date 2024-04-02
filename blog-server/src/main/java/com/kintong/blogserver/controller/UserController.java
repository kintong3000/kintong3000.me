package com.kintong.blogserver.controller;

import com.kintong.blogserver.core.ultils.ApiResult;
import com.kintong.blogserver.entity.dto.Account;
import com.kintong.blogserver.entity.vo.UserInfoVO;
import com.kintong.blogserver.service.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author kintong
 */
@RestController
@RequestMapping("/cms/UserInfo")
public class UserController {

    @Autowired
    AccountService accountService;

    @GetMapping
    public ApiResult<UserInfoVO> getUserInfo(@AuthenticationPrincipal UserDetails userDetails){
        Account account = accountService.findAccountByUserNameOrEmail(userDetails.getUsername());
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(account,userInfoVO);
        return ApiResult.success(userInfoVO);
    }

}
