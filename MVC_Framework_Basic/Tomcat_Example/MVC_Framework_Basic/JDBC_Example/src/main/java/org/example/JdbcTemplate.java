package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplate {

    public void executeUpdate(User user, String sql, PreparedStatementSetter pss) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;

        try{
            con = ConnectionManger.getConnection();
            pstmt = con.prepareStatement(sql);
            pss.setter(pstmt);

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

    public Object executeQuery(String userId, String sql, PreparedStatementSetter pss, RowMapper rowMapper) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            con = ConnectionManger.getConnection();
            pstmt = con.prepareStatement(sql);
            pss.setter(pstmt);

            rs = pstmt.executeQuery();

            Object obj = null;
            if(rs.next()){
                return rowMapper.map(rs);
            }
            return obj;
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
