package com.jianglijie.rbac.provider;

import com.jianglijie.rbac.entity.UserSearch;
import org.apache.ibatis.jdbc.SQL;

/**
 * SQL生成类 TODO
 * Created by jianglj on 2017/5/13.
 */
public class RoleDynaSqlProvider {

    private final static String TABLE_NAME = "rbac_users";

    public String getList(UserSearch userSearch) {
        String fields = userSearch.getFields();
        String uname = userSearch.getUname();
        String mobile = userSearch.getMobile();
        String sort = userSearch.getSort();
        String sortBy = userSearch.getSortBy();
        Integer offset = userSearch.getOffset();
        Integer limit = userSearch.getLimit();

        return new SQL()
        {
            {
                SELECT(fields);
                FROM(TABLE_NAME);
                WHERE("is_delete=0");
                if(uname != null){
                    AND();
                    WHERE("uname LIKE '%"+uname+"%'");
                }
                if(mobile != null){
                    AND();
                    WHERE("mobile LIKE '%"+mobile+"%'");
                }
                ORDER_BY(sort);

            }
        } .toString() + " " + sortBy + " LIMIT " + offset + "," + limit;
    }
}
