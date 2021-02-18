package com.jianglijie.rbac.controller;

import com.jianglijie.rbac.entity.Result;
import com.jianglijie.rbac.entity.User;
import com.jianglijie.rbac.entity.UserSearch;
import com.jianglijie.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * Created by jianglj on 2017/5/12.
 */
@RestController
public class RoleController extends BaseController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public Result addUser(@RequestParam("user_name") String uname,
                          @RequestParam("password") String password,
                          @RequestParam("mobile") String mobile) {

        User user = new User();
        user.setUname(uname);
        user.setPassword(password);
        user.setMobile(mobile);
        user.setIsDelete(0);
        user.setUpdateTime(0);
        user.setDeleteTime(0);

        return userService.addUser(user);
    }

    @PutMapping("/user/{id}")
    public Result updateUser(@PathVariable("id") Integer id,
                             @RequestParam("user_name") String uname,
                             @RequestParam("password") String password,
                             @RequestParam("mobile") String mobile){
        User user = new User();
        user.setId(id);
        user.setUname(uname);
        user.setPassword(password);
        user.setMobile(mobile);

        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public Result deleteUser(@PathVariable("id") Integer id){
        return userService.deleteUser(id);
    }

    @GetMapping("/user/{id}")
    public Result getUserById(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }

    @GetMapping("/user")
    public Result getUserList(@RequestParam(value = "uname", required = false) String uname,
                              @RequestParam(value = "mobile", required = false) String mobile,
                              @RequestParam(value = "sort", required = false, defaultValue = "id") String sort,
                              @RequestParam(value = "sort_by", required = false, defaultValue = "DESC") String sortBy,
                              @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
                              @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit){

        UserSearch userSearch = new UserSearch();
        userSearch.setFields("*");
        userSearch.setUname(uname);
        userSearch.setMobile(mobile);
        userSearch.setSort(sort);
        userSearch.setSortBy(sortBy);
        userSearch.setOffset(offset);
        userSearch.setLimit(limit);

        return userService.getUserList(userSearch);
    }

    @GetMapping("/test")
    public void test() throws Exception{
//        List<String > li = new ArrayList<String>();
//        String a = AesUtil.aesEncrypt("sdfsdf", this.getSerectKey());
//        byte[] bb = AesUtil.hexStr2ByteArr(a);
//        String b = AesUtil.aesDecrypt(bb, this.getSerectKey());
//        li.add(a);
//        li.add(b);
//
//        return li;
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis()/1000);
        System.out.println((int)System.currentTimeMillis()/1000);
        System.out.println(localDateTime);
        System.out.println(localDateTime.getSecond());
    }
}
