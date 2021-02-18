package com.jianglijie.rbac.service;

import com.jianglijie.rbac.entity.Result;
import com.jianglijie.rbac.entity.User;
import com.jianglijie.rbac.entity.UserSearch;
import com.jianglijie.rbac.enums.ResultEnum;
import com.jianglijie.rbac.mapper.UserMapper;
import com.jianglijie.rbac.utils.AesUtil;
import com.jianglijie.rbac.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jianglj on 2017/5/8.
 */
@Service
public class RoleService extends BaseServer{

    @Autowired
    private UserMapper userMapper;

    public Result login(String uname, String password) throws Exception{
        User user = userMapper.getOneByName(uname);

        if (user.getPassword().equals(password)){
            String tokenStr = user.getId() + "" + System.currentTimeMillis();
            String token = AesUtil.aesEncrypt(tokenStr, this.getSerectKey());
            user.setToken(token);

            return ResultUtil.success(user);
        }else{
            return ResultUtil.error(ResultEnum.LOGIN_ERROR);
        }

    }

    public Result addUser(User user){
        user.setCreateTime((int)(System.currentTimeMillis()/1000));

        Integer res = userMapper.addUser(user);
        if(res > 0) {
            return ResultUtil.success();
        }else{
            return ResultUtil.error(ResultEnum.ADD_USER_ERROR);
        }
    }

    public Result updateUser(User user){
        user.setUpdateTime((int)(System.currentTimeMillis()/1000));

        Integer res = userMapper.updateUser(user);
        if(res > 0) {
            return ResultUtil.success();
        }else{
            return ResultUtil.error(ResultEnum.UPDATE_USER_ERROR);
        }
    }

    public Result deleteUser(Integer id){
        User user = new User();
        user.setId(id);
        user.setDeleteTime((int)(System.currentTimeMillis()/1000));
        Integer res = userMapper.deleteUser(user);
        if(res > 0) {
            return ResultUtil.success();
        }else{
            return ResultUtil.error(ResultEnum.DELETE_USER_ERROR);
        }
    }

    public Result getUserById(Integer id){
        return ResultUtil.success(userMapper.getOne(id));
    }

    public Result getUserList(UserSearch userSearch){
        return ResultUtil.success(userMapper.getList(userSearch));
    }

}
