package com.jianglijie.rbac.utils;

import com.jianglijie.rbac.entity.Result;
import com.jianglijie.rbac.enums.ResultEnum;

/**
 * Created by jianglj on 2017/5/8.
 */
public class ResultUtil {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(ResultEnum resultEnum) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return result;
    }

}
