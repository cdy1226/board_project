package org.zerock.w2.controller;

import org.zerock.w2.service.TodoService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "todoRemoveController", value = "/todo/remove")
public class TodoRemoveController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long tno = Long.parseLong(request.getParameter("tno"));
        try{
            todoService.remove(tno);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/todo/list");
    }
}
