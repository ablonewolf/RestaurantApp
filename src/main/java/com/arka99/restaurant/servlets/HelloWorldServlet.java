package com.arka99.restaurant.servlets;

import java.io.*;
import java.util.Date;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloWorldServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "The current time is: " + new Date();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html><body>");
        printWriter.println("<h1>Hello World</h1>");
        printWriter.println("<p>" + message + "</p>");
        printWriter.println("</body></html>");
    }

    public void destroy() {
    }
}