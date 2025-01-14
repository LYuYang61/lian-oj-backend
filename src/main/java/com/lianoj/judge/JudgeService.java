package com.lianoj.judge;

import com.lianoj.model.entity.QuestionSubmit;

/**
 * @author lian
 * @title JudgeService
 * @date 2025/1/13 23:38
 * @description 判题服务
 */
public interface JudgeService {
    /**
     * 判题
     *
     * @param questionSubmitId
     * @return
     */
    QuestionSubmit doJudge(long questionSubmitId);
}
