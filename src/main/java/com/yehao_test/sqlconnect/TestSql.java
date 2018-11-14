package com.yehao_test.sqlconnect;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestSql {

    public static void main(String[] args) {
       SqlConnection sqlConnection = new SqlConnection();
       String sqlString = "select * from user where username like '%yehao%8%'";
       try {
        sqlConnection.getConnection();
        sqlConnection.getPreparedStatement(sqlString);
        ResultSet resultSet = sqlConnection.getResultSet();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
        }
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }finally{
        sqlConnection.colse();
    }
       
    }

}
