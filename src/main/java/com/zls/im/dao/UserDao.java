package com.zls.im.dao;

import com.zls.im.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserDao {

    @Select("select * from user where id = #{id}")
    public User getById(@Param("id") Integer id);

    @Select("insert into user (id,name) values (#{id}, #{name})")
    public boolean insert(User user);
}
