package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public void create(User user) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;

        try{
            con = ConnectionManger.getConnection();
            String sql = "INSERT INTO USERS VALUES (?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());

            pstmt.executeUpdate();
        }finally {
            //자원 해제
            if(pstmt != null){
                pstmt.close();
            }
            if(con!=null){
                con.close();
            }
        }
    }

    public User findByUserId(String userId) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            con = ConnectionManger.getConnection();
            String sql = "SELECT userId, password, name, email FROM USERS where userId=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userId);

            rs = pstmt.executeQuery();

            User user = null;
            if(rs.next()){
                user = new User(
                    rs.getString("userId"),
                    rs.getString("password"),
                    rs.getString("name"),
                    rs.getString("email")
                    );
            }
            return user;
        }finally {
            if(pstmt != null){
                pstmt.close();
            }
            if(con!=null){
                con.close();
            }
            if(rs!=null){
                rs.close();
            }
        }
    }
}
