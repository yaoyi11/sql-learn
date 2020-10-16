package com.sqlite;

import java.sql.*;

public class AppMain {
    private static String Drivde="org.sqlite.JDBC";
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Class.forName(Drivde);
        Connection conn= DriverManager.getConnection("jdbc:sqlite:D:\\files\\note\\test1.db");
        insertSql(conn,120, "yao3", 66);
        delSno(conn,112);
        updateSno(conn,24,110);
        selectSno(conn,110);

        conn.close();

    }
    public static void insertSql(Connection connection, Integer sno, String name, Integer age) throws SQLException{
        Statement state = connection.createStatement();
        String sql = String.format("insert into student (sno, name, age) values (%d,'%s',%d)",sno,name,age);
        state.executeUpdate(sql); //插入数据
        System.out.println("insert success");

    }
    public static void selectSno(Connection connection, Integer sno) throws SQLException{
        Statement state = connection.createStatement();
        String sql = String.format("select * from student where sno=%d", sno);
        ResultSet rs = state.executeQuery(sql);
        while (rs.next()) { //将查询到的数据打印出来
            System.out.print("name = " + rs.getString("name") + " "); //列属性一
            System.out.println("age = " + rs.getString("age")); //列属性二
        }
        rs.close();
    }
    public static void delSno(Connection connection, Integer sno) throws SQLException{
        Statement state = connection.createStatement();
        String sql = String.format("delete from student where sno=%d", sno);
        state.executeUpdate(sql);
        System.out.print("delete success\n");

    }
    public static void updateSno(Connection connection, Integer age, Integer sno) throws SQLException{
        Statement state = connection.createStatement();
        String sql = String.format("update student set age=24 where sno=%d", sno);
        state.executeUpdate(sql);
        System.out.print("update success\n");
    }
}
