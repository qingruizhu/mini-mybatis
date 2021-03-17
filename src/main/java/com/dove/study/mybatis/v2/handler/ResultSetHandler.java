package com.dove.study.mybatis.v2.handler;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description: 结果集处理
 * @Auther: qingruizhu
 * @Date: 2021/3/17 上午9:14
 */
public class ResultSetHandler {

    public <T> T handler(ResultSet rs, Class type) {
        try {
            if (!rs.next()) return null;
            // 反射处理结果
            Object pojo = null;
            try {
                pojo = type.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            Field[] fields = type.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                Class<?> fieldType = field.getType();
                String fieldName = field.getName();
                // 驼峰字段转下划线对应数据库
                String dbColumName = filedNameToDbColumName(fieldName);
                if (fieldType == String.class) {
                    String rsString = rs.getString(dbColumName);
                    setFiledValue(type, fieldName, fieldType, pojo, rsString);
                } else if (fieldType == Integer.class) {
                    int anInt = rs.getInt(dbColumName);
                    setFiledValue(type, fieldName, fieldType, pojo, anInt);
                } else if (fieldType == Long.class) {
                    long aLong = rs.getLong(dbColumName);
                    setFiledValue(type, fieldName, fieldType, pojo, aLong);
                } else if (fieldType == Double.class) {
                    double aDouble = rs.getDouble(dbColumName);
                    setFiledValue(type, fieldName, fieldType, pojo, aDouble);
                } else if (fieldType == Boolean.class) {
                    boolean aBoolean = rs.getBoolean(dbColumName);
                    setFiledValue(type, fieldName, fieldType, pojo, aBoolean);
                } else {
                    String rsString = rs.getString(dbColumName);
                    setFiledValue(type, fieldName, fieldType, pojo, rsString);
                }
            }
            System.out.println(pojo.toString());
            return (T) pojo;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void setFiledValue(Class type, String fieldName, Class fieldType, Object pojo, Object value) {
        Method method = null;
        try {
            method = type.getMethod("set" + firstWordCapital(fieldName), fieldType);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            method.invoke(pojo, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        String abc = filedNameToDbColumName("aBc");
//    }

    /**
     * pojo 驼峰字段转为对应数据库字段的下划线
     *
     * @param fieldName
     * @return
     */
    private static String filedNameToDbColumName(String fieldName) {
        char[] chars = fieldName.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char chr = chars[i];
            byte b = (byte) chr;
            if (b >= 65 && b <= 90) {
                sb.append("_");
                b += 32;
                char cc = (char) b;
                sb.append(cc);
            } else {
                sb.append(chr);
            }
        }
        return sb.toString();
    }

    /**
     * 首字母大写
     *
     * @param name
     * @return
     */
    private String firstWordCapital(String name) {
        String first = name.substring(0, 1);
        String tail = name.substring(1);
        String upperCase = first.toUpperCase();
        return upperCase + tail;

    }


}
