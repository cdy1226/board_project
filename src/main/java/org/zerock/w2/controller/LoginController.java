package org.zerock.w2.controller;

import org.zerock.w2.dao.ConnectionUtil;
import org.zerock.w2.dto.MemberDTO;
import org.zerock.w2.service.MemberService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("login get....");
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mid = request.getParameter("mid");
        String mpw = request.getParameter("mpw");
        String auto = request.getParameter("auto");
        boolean rememberMe = auto!=null && auto.equals("on");

        if(rememberMe){
            String uuid = UUID.randomUUID().toString();
        }
        try {
            MemberDTO memberDTO = MemberService.INSTANCE.login(mid, mpw);

            if(rememberMe){
                String uuid = UUID.randomUUID().toString();
                MemberService.INSTANCE.updateUUID(mid, uuid);
                memberDTO.setUuid(uuid);

                Cookie rememberCookie = new Cookie("remember-me", uuid);
                rememberCookie.setMaxAge(60*60*24*7);
                rememberCookie.setPath("/");
                response.addCookie(rememberCookie);
            }

            HttpSession session = request.getSession();
            session.setAttribute("loginInfo", memberDTO);
            response.sendRedirect("/todo/list");
        }catch(Exception e){
            response.sendRedirect("/login?result=error");
        }
        /*
        String str = mid+mpw;
        HttpSession session = request.getSession();
        session.setAttribute("loginInfo", str);
        //String name = (String) session.getAttribute("str");
        response.sendRedirect("/todo/list");
        */

    }
}
