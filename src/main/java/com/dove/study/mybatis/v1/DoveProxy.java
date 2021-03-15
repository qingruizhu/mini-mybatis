package com.dove.study.mybatis.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2021/3/15 下午4:36
 */
public class DoveProxy implements InvocationHandler {
    private DoveSqlSesssion sqlSesssion;

    public DoveProxy(DoveSqlSesssion sqlSesssion) {
        this.sqlSesssion = sqlSesssion;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String statementId = method.getDeclaringClass().getName() + "." + method.getName();
        if (null != statementId && !"".equals(statementId)) {
            return sqlSesssion.selectOne(statementId, args[0]);
        }
        return null;
    }
}
