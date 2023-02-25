package com.itheima.mybatis_plus_learn.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.mybatis_plus_learn.domain.User;

@Mapper
public interface UserDao extends BaseMapper<User>{

}
