package com.lianoj.judge.codesandbox;

import com.lianoj.model.enums.QuestionSubmitLanguageEnum;
import com.lianoj.judge.codesandbox.impl.RemoteCodeSandbox;
import com.lianoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.lianoj.judge.codesandbox.model.ExecuteCodeResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.lianoj.judge.codesandbox.CodeSandboxFactory.newInstance;

/**
 * @author lian
 * @title CodeSandboxTest
 * @date 2025/1/13 23:12
 * @description 代码沙箱测试
 */
@SpringBootTest
public class CodeSandboxTest {
    @Value("${codesandbox.type:example}")
    private String type;

    /**
     * 测试执行代码
     */
    @Test
    void executeCode() {
        CodeSandbox codeSandbox = new RemoteCodeSandbox();
        String code = "int main() { }";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }

    @Test
    void executeCodeByProxy() {
        System.out.println("type = " + type);
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        codeSandbox = new CodeSandboxProxy(codeSandbox);
        String code = "public class Main {\n" +
                "    public static void main(String[] args) {\n" +
                "        int a = Integer.parseInt(args[0]);\n" +
                "        int b = Integer.parseInt(args[1]);\n" +
                "        System.out.println(\"结果:\" + (a + b));\n" +
                "    }\n" +
                "}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }

    /**
     * 工厂模式测试执行代码
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String type = scanner.next();
            CodeSandbox codeSandbox = newInstance(type);
            codeSandbox = new CodeSandboxProxy(codeSandbox);    // 代码沙箱代理
            String code = "public class Main {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        int a = Integer.parseInt(args[0]);\n" +
                    "        int b = Integer.parseInt(args[1]);\n" +
                    "        System.out.println(\"结果:\" + (a + b));\n" +
                    "    }\n" +
                    "}";
            String language = QuestionSubmitLanguageEnum.JAVA.getValue();
            List<String> inputList = Arrays.asList("1 2", "3 4");
            ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                    .code(code)
                    .language(language)
                    .inputList(inputList)
                    .build();
            ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
            Assertions.assertNotNull(executeCodeResponse);
        }
    }

}
