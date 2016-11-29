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
            if (rs.next()) {
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
}
