package com.dove.study.mybatis.v1;

import java.util.ResourceBundle;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2021/3/15 下午4:15
 */
public class DoveConfiguration {

    private static ResourceBundle sqlMappings;

    static {
        sqlMappings = ResourceBundle.getBundle("v1sql");
    }


    public String getSql(String statementId) {
        return sqlMappings.getString(statementId);
    }
}
