package com.segmentfault.springboot.lession7;

import com.segmentfault.springboot.lession7.entity_by_starter.User;
import com.segmentfault.springboot.lession7.mybatis.mappers_by_starter.UserMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private List<DataSource> dataSourceList;

    @GetMapping("/users/{userId}")
    public User findUserById(@PathVariable Integer userId) {

        UserMapper mapperByStarter = sqlSessionTemplate.getMapper(UserMapper.class);
        User userByStarter = mapperByStarter.findUserById(userId);
        System.out.println(userByStarter);

        com.segmentfault.springboot.lession7.mybatis.mappers_by_annotation.UserMapper mapperByAnnotation =
                sqlSessionTemplate.getMapper(com.segmentfault.springboot.lession7.mybatis.mappers_by_annotation.UserMapper.class);
        com.segmentfault.springboot.lession7.entity_by_annotation.User userByAnnotation =
                mapperByAnnotation.findUserById(userId);
        System.out.println(userByAnnotation);

        return userByStarter;
    }
}
