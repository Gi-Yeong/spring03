package com.guest.model;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GuestDaoTest {

    private static GuestDao dao;

    @BeforeClass
    public static void beforeDao() {
        dao = new GuestDao();
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