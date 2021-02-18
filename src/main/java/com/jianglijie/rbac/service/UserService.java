package com.jianglijie.rbac.service;

import com.jianglijie.rbac.entity.Result;
import com.jianglijie.rbac.entity.User;
import com.jianglijie.rbac.enums.ResultEnum;
import com.jianglijie.rbac.mapper.UserMapper;
import com.jianglijie.rbac.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jianglj on 2017/5/8.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Result login(String uname, String password){
        User user = userMapper.getOne(uname);

        if (user.getPassword().equals(password)){
            return ResultUtil.success(user);
        }else{
            return ResultUtil.error(ResultEnum.LOGIN_ERROR);
        }

    }

}
