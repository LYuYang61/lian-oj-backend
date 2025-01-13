package com.lianoj.judge.codesandbox.impl;

import com.lianoj.judge.codesandbox.CodeSandbox;
import com.lianoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.lianoj.judge.codesandbox.model.ExecuteCodeResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lian
 * @title ExampleCodeSandbox
 * @date 2025/1/13 23:05
 * @description 示例代码沙箱
 */
@Slf4j
public class ExampleCodeSandbox implements CodeSandbox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        log.info("执行示例代码沙箱");
        return new ExecuteCodeResponse();
    }
}
