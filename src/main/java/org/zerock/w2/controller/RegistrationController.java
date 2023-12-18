package org.zerock.w2.controller;
import org.zerock.w2.dto.RegistrationDTO;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.service.RegistrationService;
import org.zerock.w2.service.TodoService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
@WebServlet("/registration")
public class RegistrationController extends HttpServlet {
    private RegistrationService registrationService = RegistrationService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Member Registration get....");
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RegistrationDTO registrationDTO = RegistrationDTO.builder()
                .mid(request.getParameter("mid"))
                .mpw(request.getParameter("mpw"))
                .mname(request.getParameter("mname"))
                .age(Integer.valueOf(request.getParameter("age")))
                .email(request.getParameter("email"))
                .build();
        try {
            registrationService.register(registrationDTO);
            System.out.println("회원가입 성공");
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/login");
    }

}
