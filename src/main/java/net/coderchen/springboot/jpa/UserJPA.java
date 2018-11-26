package net.coderchen.springboot.jpa;

import net.coderchen.springboot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @Author Liuyuchen
 * @Date 2018/11/26
 * @Description
 * JpaRepository - SpringDataJPA提供的简单数据操作接口
 * JpaSpecificationExecutor - SpringDataJPA提供的复杂查询接口
 */
public interface UserJPA extends
        JpaRepository<UserEntity, Integer>,
        JpaSpecificationExecutor<UserEntity>,
        Serializable {
}
