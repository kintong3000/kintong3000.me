package com.kintong.blogserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kintong.blogserver.entity.dto.Introduction;
import com.kintong.blogserver.mapper.IntroductionMapper;
import com.kintong.blogserver.service.IntroductionService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 * @Author kintong
 */
@Service
public class IntroductionServiceImpl extends ServiceImpl<IntroductionMapper, Introduction> implements IntroductionService {

    @Override
    public Introduction getIndex() {
        return this.query().one();
    }

    @Override
    public boolean updateIntroduction(Introduction introduction) {
        try {
            this.saveOrUpdate(introduction);
            return true; // 如果没有异常发生，表示保存成功
        } catch (DataIntegrityViolationException e) {
            // 在这里处理违反数据完整性的异常，例如重复的键
            return false; // 返回false，表示保存失败
        }
    }
}
