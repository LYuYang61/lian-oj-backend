package com.lianoj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianoj.model.entity.Question;
import com.lianoj.service.QuestionService;
import com.lianoj.mapper.QuestionMapper;
import org.springframework.stereotype.Service;

/**
* @author Lenovo
* @description 针对表【question(题目)】的数据库操作Service实现
* @createDate 2025-01-09 10:50:49
*/
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question>
    implements QuestionService{

}




