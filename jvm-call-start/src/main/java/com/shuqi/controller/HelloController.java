package com.shuqi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author olifer
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello world";
    }

    /**
     * 一个无限循环，测试占用CPU资源的case
     * @return
     */
    @RequestMapping(value = "/1",method = RequestMethod.GET)
    public String test1(){
        while (true){

        }
    }
}
