package org.zerock.w2.controller;

import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.service.TodoService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "todoRegisterController", value = "/todo/register")
public class TodoRegisterController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if(session.isNew()){ //기존에 JSESSIONID가 없는 새로운 사용자
            System.out.println("JSESSIONID 쿠키가 새로 만들어진 사용자");
            response.sendRedirect("/login");
            return;
        }

        //JSESSIONID는 있지만 해당 세션컨텍스트에 로그인정보가 없는 경우
        if(session.getAttribute("loginInfo") == null){
            System.out.println("로그인한 정보가 없는 사용자");
            response.sendRedirect("/login");
            return;
        }

        //로그인을 한 경우
        request.getRequestDispatcher("/WEB-INF/todo/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TodoDTO todoDTO = TodoDTO.builder()
                .title(request.getParameter("title"))
                .dueDate(LocalDate.parse(request.getParameter("dueDate"),DATEFORMATTER))
                .build();
        try{
            todoService.register(todoDTO);
        }catch(Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/todo/list");
    }
}
