package com.jianglijie.rbac.mapper;

import com.jianglijie.rbac.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by jianglj on 2017/5/8.
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM rbac_users WHERE uname = #{uname}")
    User getOne(String uname);

}
