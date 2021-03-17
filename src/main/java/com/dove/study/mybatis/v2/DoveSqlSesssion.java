package com.dove.study.mybatis.v2;

import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2021/3/15 下午4:09
 */
public class DoveSqlSesssion {

    private DoveConfiguration doveConfiguration;
    private DoveExecutor doveExecutor;

    public DoveSqlSesssion(DoveConfiguration doveConfiguration, DoveExecutor doveExecutor) {
        this.doveConfiguration = doveConfiguration;
        this.doveExecutor = doveExecutor;
    }

    public <T> T getMapper(Class clzz,Class pojo) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{clzz}, new DoveProxy(this,pojo));
    }


    public <T> T selectOne(String statementId, Object[] parameter, Class pojo) {
        String sql = doveConfiguration.getSql(statementId);
        if (null != sql && !"".equals(sql)) {
            return doveExecutor.query(sql, parameter, pojo);
        }
        return null;
    }
}
