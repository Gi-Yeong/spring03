package com.guest.controller;

import com.guest.model.GuestDao;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OneController extends AbstractController {
    private GuestDao dao;
    private String page;

    public void setPage(String page) {
        this.page = page;
    }

    public void setDao(GuestDao dao) {
        this.dao = dao;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView();

        String param = httpServletRequest.getParameter("idx");
        int sabun = Integer.parseInt(param);

        mav.addObject("dto", dao.selectOne(sabun));
        mav.setViewName("guest/" + page);

        return mav;
    }
}
