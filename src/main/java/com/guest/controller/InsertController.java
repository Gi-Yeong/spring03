package com.guest.controller;

import com.guest.model.GuestDao;
import com.guest.model.GuestVo;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertController extends AbstractCommandController {
    private GuestDao dao;

    public void setDao(GuestDao dao) {
        this.dao = dao;
    }

    @Override
    protected ModelAndView handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, BindException e) throws Exception {

        GuestVo bean = (GuestVo) o;
        dao.insertOne(bean);

        return new ModelAndView("redirect:list.do");
    }
}
