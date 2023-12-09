package com.arka99.restaurant.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

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