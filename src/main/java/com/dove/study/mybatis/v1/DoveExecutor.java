package com.dove.study.mybatis.v1;

import com.dove.study.mybatis.v1.mapper.Book;

import java.sql.*;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2021/3/15 下午4:15
 */
public class DoveExecutor {

    public <T> T query(String sql, Object parameter) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://123.57.102.27:3306/zqr_dove_book", "root", "Zqr596799655");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement = null;
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(String.format(sql, parameter));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                if (!rs.next()) break;
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String book_desc = rs.getString("book_desc");
                Book book = new Book();
                book.setId(id);
                book.setName(name);
                book.setBookDesc(book_desc);
                System.out.println(book);
                return (T) book;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
