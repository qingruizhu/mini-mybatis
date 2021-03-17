package com.dove.study.mybatis.v2;

import com.dove.study.mybatis.v2.handler.StatementHandler;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2021/3/15 下午4:15
 */
public class DoveExecutor {

    public <T> T query(String sql, Object[] parameters,Class pojo) {
        StatementHandler statementHandler = new StatementHandler();
        return statementHandler.query(sql, parameters,pojo);
    }

}
