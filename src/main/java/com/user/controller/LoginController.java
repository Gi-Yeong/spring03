package com.user.controller;

import com.user.model.LoginBean;
import com.user.model.UserDao;
import com.user.model.UserVo;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController implements Controller {
    private UserDao dao;

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView();
        String id = httpServletRequest.getParameter("id").trim();
        String pw = httpServletRequest.getParameter("pw").trim();
        UserVo bean = dao.login(id, pw);
        if (bean.getLogin().equals("TRUE")) {
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("result", true);
            session.setAttribute("id", id);
            mav.setViewName("redirect:bbs/list.do");
        } else {
            mav.addObject("errMSG", "로그인 실패");
            mav.setViewName("user/login");
        }
        return mav;
    }
}
