package com.yehao_test.sqlconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class SqlConnection {
    private String url = "jdbc:mysql://localhost:3306/yehao_test";
    private String userString = "root";
    private String password = "123456";
    
    private  Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    public void getConnection() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, userString, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void getPreparedStatement(String sql){
        try {
            preparedStatement = this.connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet getResultSet() {
        try {
            resultSet = this.preparedStatement.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultSet;
    }
    
    public void colse(){
        try {
            this.resultSet.close();
            this.preparedStatement.close();
            this.connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
