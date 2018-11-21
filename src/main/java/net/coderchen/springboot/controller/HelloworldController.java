package net.coderchen.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author coderchen
 * 2018/11/21 21:47
 */
@RestController
@RequestMapping("/hello")
public class HelloworldController {

    @RequestMapping("/sayHello")
    public String sayHello(){
        return "hello";
    }
}
