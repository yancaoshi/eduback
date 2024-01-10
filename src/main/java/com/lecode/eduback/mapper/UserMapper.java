package com.lecode.eduback.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lecode.eduback.model.User;

public interface UserMapper extends BaseMapper<User> {


    void getUserById(Integer sid);
}