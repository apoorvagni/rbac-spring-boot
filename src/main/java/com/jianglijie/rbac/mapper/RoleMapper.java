package com.jianglijie.rbac.mapper;

import com.jianglijie.rbac.entity.User;
import com.jianglijie.rbac.entity.UserSearch;
import com.jianglijie.rbac.provider.UserDynaSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by jianglj on 2017/5/8.
 */
@Mapper
public interface RoleMapper {

//    @Select("<script> SELECT #{fields} FROM rbac_users " +
//            " <where> is_delete=0" +
//            " <if test=\"uname != null\"> AND uname=#{uname}</if> " +
//            " <if test=\"mobile != null\"> AND mobile=#{mobile}</if> " +
//            " </where> " +
//            "ORDER BY #{sort} #{sortBy} LIMIT #{offset},#{limit}</script>")
    @SelectProvider(type = UserDynaSqlProvider.class, method = "getList")
    @Results({
            @Result(property = "isDelete", column = "is_delete"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "deleteTime", column = "delete_time")
    })
    List<User> getList(UserSearch userSearch);

    @Select("SELECT * FROM rbac_users WHERE id = #{id}")
    @Results({
            @Result(property = "isDelete", column = "is_delete"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "deleteTime", column = "delete_time")
    })
    User getOne(Integer id);

    @Select("SELECT * FROM rbac_users WHERE uname = #{uname}")
    @Results({
            @Result(property = "isDelete", column = "is_delete"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "deleteTime", column = "delete_time")
})
    User getOneByName(String uname);

    @Insert("INSERT INTO rbac_users(uname,password,mobile,create_time) VALUES(#{uname}, #{password}, #{mobile}, #{createTime})")
    Integer addUser(User user);

    @Update("UPDATE rbac_users SET uname=#{uname}, password=#{password}, mobile=#{mobile}, update_time=#{updateTime} WHERE id=#{id}")
    Integer updateUser(User user);

    @Update("UPDATE rbac_users SET is_delete=1, delete_time=#{deleteTime} WHERE id=#{id}")
    Integer deleteUser(User user);

}
