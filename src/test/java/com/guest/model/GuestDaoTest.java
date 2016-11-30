package com.guest.model;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class GuestDaoTest {
    private static GuestDao dao;

    @BeforeClass
    public static void beforeDao() {
        dao = new GuestDao();
    }

    @Test
    public void insertOne() throws Exception {
        List<GuestVo> list = dao.selectAll();
        int beforeCnt = list.size();
        GuestVo bean = new GuestVo(5555, "bbbb", new Date(), 2000);
        dao.insertOne(bean);
        list = dao.selectAll();
        int afterCnt = list.size();
        assertSame(beforeCnt+1, afterCnt);
        dao.deleteOne(5555);
        list = dao.selectAll();
        afterCnt = list.size();
        assertSame(beforeCnt, afterCnt);
    }

    @Test
    public void deleteOne() throws Exception {

    }


    @Test
    public void selectAll() {
        try {
            List list = dao.selectAll();
            assertNotNull(list);
            assertTrue(list.size() > 0);
            return;
        } catch (Exception e) {
            fail("Not yet implemented");
        }
    }

}