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
    public void testInsertDelete() throws Exception {
        GuestVo bean = new GuestVo(9999, "test", new Date(), 2000);
        insertOne(bean);
        selectOne(bean);
        deleteOne(bean);
        bean.setName("test2");
        bean.setPay(9090);
        updateOne(bean);
        selectOne(bean);
        selectAll();
    }

    public void insertOne(GuestVo bean) throws Exception {
        dao.insertOne(bean);
    }

    public void selectOne(GuestVo bean) throws Exception {
        GuestVo dto = dao.selectOne(bean.getSabun());
        assertNotNull(dto);
        assertEquals(bean, dto);
    }

    public void deleteOne(GuestVo bean) throws Exception {
        dao.deleteOne(bean.getSabun());
    }

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

    public void updateOne(GuestVo bean) throws Exception {
        dao.updateOne(bean);
    }
}
