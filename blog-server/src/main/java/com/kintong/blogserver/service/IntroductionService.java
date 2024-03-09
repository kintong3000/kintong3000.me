package com.kintong.blogserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kintong.blogserver.entity.dto.Introduction;

/**
 * @Author kintong
 */
public interface IntroductionService extends IService<Introduction> {

    public Introduction getIndex();

    public boolean updateIntroduction(Introduction introduction);
}
