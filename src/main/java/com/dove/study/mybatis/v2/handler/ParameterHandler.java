package com.dove.study.mybatis.v2.handler;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Description: 参数处理
 * @Auther: qingruizhu
 * @Date: 2021/3/17 上午9:14
 */
public class ParameterHandler {

    public void handler(PreparedStatement pst, Object[] parameters) {
        for (int i = 0; i < parameters.length; i++) {
            Object param = parameters[i];
            try {
                if (param instanceof String) {
                    pst.setString(i+1, (String) param);
                } else if (param instanceof Integer) {
                    pst.setInt(i+1, (Integer) param);
                } else if (param instanceof Double) {
                    pst.setDouble(i+1, (Double) param);
                } else if (param instanceof Long) {
                    pst.setLong(i+1, (Long) param);
                } else if (param instanceof Boolean) {
                    pst.setBoolean(i+1, (Boolean) param);
                } else {
                    pst.setString(i+1, (String) param);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
