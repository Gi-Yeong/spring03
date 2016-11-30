package com.guest.model;

import com.user.util.OraDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GuestDao {

    private PreparedStatement pstmt;
    private ResultSet rs;

    public List<GuestVo> selectAll() throws Exception {
        List<GuestVo> list = new ArrayList<>();
        String sql = "SELECT * FROM GUEST ORDER BY SABUN";
        try {
            pstmt = OraDB.getConn().prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new GuestVo(
                        rs.getInt("sabun")
                        , rs.getString("name")
                        , rs.getDate("nalja")
                        , rs.getInt("pay")
                ));
            }
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (OraDB.getConn() != null) OraDB.getConn().close();
        }
        return list;
    }

    public void insertOne(GuestVo bean) throws Exception {
        String sql = "INSERT INTO GUEST VALUES (?, ?, sysdate, ?)";
        try {
            pstmt = OraDB.getConn().prepareStatement(sql);
            pstmt.setInt(1, bean.getSabun());
            pstmt.setString(2, bean.getName());
            pstmt.setInt(3, bean.getPay());
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) pstmt.close();
            if (OraDB.getConn() != null) OraDB.getConn().close();
        }
    }

    public void deleteOne(int sabun) throws Exception {
        String sql = "DELETE FROM GUEST WHERE SABUN = ?";
        try {
            pstmt = OraDB.getConn().prepareStatement(sql);
            pstmt.setInt(1, sabun);
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) pstmt.close();
            if (OraDB.getConn() != null) OraDB.getConn().close();
        }
    }

    public GuestVo selectOne(int sabun) throws Exception {
        String sql = "SELECT * FROM GUEST WHERE SABUN = ?";
        try {
            pstmt = OraDB.getConn().prepareStatement(sql);
            pstmt.setInt(1, sabun);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return new GuestVo(
                        rs.getInt("sabun")
                        , rs.getString("name")
                        , rs.getDate("nalja")
                        , rs.getInt("pay"));
            }
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (OraDB.getConn() != null) OraDB.getConn().close();
        }

        return null;
    }

    public void updateOne(GuestVo bean) throws Exception {
        String sql = "UPDATE GUEST SET NAME = ?, PAY = ? WHERE SABUN = ?";
        try {
            pstmt = OraDB.getConn().prepareStatement(sql);
            pstmt.setString(1, bean.getName());
            pstmt.setInt(2, bean.getPay());
            pstmt.setInt(3, bean.getSabun());
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) pstmt.close();
            if (OraDB.getConn() != null) OraDB.getConn().close();
        }
    }
}
