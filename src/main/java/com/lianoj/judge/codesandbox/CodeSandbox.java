package com.lianoj.judge.codesandbox;

import com.lianoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.lianoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * @author lian
 * @title CodeSandbox
 * @date 2025/1/13 23:00
 * @description 代码沙箱接口定义
 */
public interface CodeSandbox {

    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
