package org.zerock.w2.controller;

import org.zerock.w2.dto.MemberDTO;
import org.zerock.w2.dto.RegistrationDTO;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.service.MemberService;
import org.zerock.w2.service.RegistrationService;
import org.zerock.w2.service.TodoService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/memberList")
public class MemberListController extends HttpServlet {

    private RegistrationService registrationService = RegistrationService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<RegistrationDTO> dtoList = registrationService.listAll();
            request.setAttribute("dtoList", dtoList);
            System.out.println(dtoList);
            request.getRequestDispatcher("/WEB-INF/memberList.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
