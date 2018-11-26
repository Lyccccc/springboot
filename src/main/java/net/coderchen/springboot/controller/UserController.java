package net.coderchen.springboot.controller;

import net.coderchen.springboot.entity.UserEntity;
import net.coderchen.springboot.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Liuyuchen
 * @Date 2018/11/26
 * @Description
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserJPA userJPA;

    @RequestMapping("/list")
    public List<UserEntity> list(){
        return userJPA.findAll();
    }
}
