package com.dove.study.mybatis.v2.handler;

import com.dove.study.mybatis.v2.DoveConfiguration;

import java.sql.*;

/**
 * @Description: 状态集处理
 * @Auther: qingruizhu
 * @Date: 2021/3/16 下午2:41
 */
public class StatementHandler {


    public <T> T query(String sql, Object[] parameters, Class pojo) {
        Connection conn = getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            // 1.处理参数
            ParameterHandler parameterHandler = new ParameterHandler();
            parameterHandler.handler(pst, parameters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            // 2.执行
            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = pst.getResultSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 3.处理结果集
        ResultSetHandler resultSetHandler = new ResultSetHandler();
        T handler = resultSetHandler.handler(rs, pojo);
        try {
            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return handler;
    }


    public Connection getConnection() {
        String dr = DoveConfiguration.getPropertiesValue("jdbc.driver");
        String url = DoveConfiguration.getPropertiesValue("jdbc.url");
        String username = DoveConfiguration.getPropertiesValue("jdbc.username");
        String password = DoveConfiguration.getPropertiesValue("jdbc.password");
        try {
            Class.forName(dr);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
