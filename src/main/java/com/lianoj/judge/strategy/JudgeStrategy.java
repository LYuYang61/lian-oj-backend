package com.lianoj.judge.strategy;

import com.lianoj.model.dto.questionsubmit.JudgeInfo;

/**
 * @author lian
 * @title JudgeStrategy
 * @date 2025/1/14 10:45
 * @description 判题策略
 */
public interface JudgeStrategy {

    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}
