package com.jianzh5.provider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jam
 * 公众号：JAVA日知录
 * @date 2022/8/31 22:09
 */
@RestController
@RequestMapping("provider")
public class DemoConrtoller {
    @GetMapping("hello")
    public String say(){
        return "Hello,World!";
    }
}
