package net.coderchen.springboot.controller;

import net.coderchen.springboot.entity.UserEntity;
import net.coderchen.springboot.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @Author Liuyuchen
 * @Date 2018/11/29
 * @Description
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserJPA userJPA;

    /**
     * 判断用户名密码是否匹配
     * @param userEntity 前端传入的用户对象
     * @return 成功标识
     */
    @RequestMapping("/check")
    public String check(UserEntity userEntity, HttpServletRequest request){
        Optional<UserEntity> optionalUserEntity = userJPA.findOne(new Specification<UserEntity>() {
            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                criteriaQuery.where(criteriaBuilder.equal(root.get("name"), userEntity.getName()));
                return null;
            }
        });
        UserEntity selectedUserEntity = optionalUserEntity.get();
        System.out.println(selectedUserEntity);
        if(null == selectedUserEntity){
            return "用户不存在";
        }
        if(!userEntity.getPwd().equals(selectedUserEntity.getPwd())){
            return "密码错误";
        }
        //成功登录，写入session
        request.getSession().setAttribute("sessionUser", userEntity.getName());
        return "success";
    }
}
