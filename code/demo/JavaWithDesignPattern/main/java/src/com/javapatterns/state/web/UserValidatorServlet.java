package com.javapatterns.state.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

public class UserValidatorServlet extends HttpServlet
{
    private LoginState loginState = null;

    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
        // Write your code here
    }

    public void destroy()
    {
        // Write your code here
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Set content-type header before accessing the Writer
        response.setContentType("text/html");
        // Write the data of the response
        PrintWriter out = response.getWriter();
        // Write your code here
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Set content-type header before accessing the Writer
        response.setContentType("text/html");
        // Write the data of the response
        PrintWriter out = response.getWriter();
        // Write your code here
        out.close();
    }

    public long getLastModified(HttpServletRequest request)
    {
        // Write your code here
        return -1;
    }
}
