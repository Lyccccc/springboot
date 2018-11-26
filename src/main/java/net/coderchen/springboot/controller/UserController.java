package net.coderchen.springboot.controller;

import net.coderchen.springboot.entity.UserEntity;
import net.coderchen.springboot.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/save")
    public UserEntity save(@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("address") String address){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setAge(age);
        userEntity.setAddress(address);
        return userJPA.save(userEntity);
    }

    @RequestMapping("/delete")
    public List<UserEntity> delete(@RequestParam("id") int id){
        userJPA.deleteById(id);
        return userJPA.findAll();
    }
}
