package com.dove.study.mybatis.v2;

import java.util.ResourceBundle;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2021/3/15 下午4:15
 */
public class DoveConfiguration {

    private static ResourceBundle sqlMappings;
    private static ResourceBundle properties;

    static {
        sqlMappings = ResourceBundle.getBundle("v2sql");
        properties = ResourceBundle.getBundle("mybatis");
    }


    public String getSql(String statementId) {
        return sqlMappings.getString(statementId);
    }

    public static String getPropertiesValue(String key) {
        return properties.getString(key);
    }

}
