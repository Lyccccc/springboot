package net.coderchen.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author coderchen
 * 2018/11/21 22:00
 * 测试jsp功能
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    /**
     * 初始化登录页面
     */
    @RequestMapping(value = "/loginView", method = RequestMethod.GET)
    public String loginView(){
        return "login";
    }
}
