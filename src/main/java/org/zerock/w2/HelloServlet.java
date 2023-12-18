package org.zerock.w2;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();

        session.setAttribute("username", "Hong");

        String username = (String) session.getAttribute("username");

        response.getWriter().println("username from session : "+username);
    }

}