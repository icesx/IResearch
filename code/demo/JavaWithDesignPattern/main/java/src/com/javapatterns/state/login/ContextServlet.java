package com.javapatterns.state.login;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

public class ContextServlet extends HttpServlet
{
    private UserState userState = new LogoutState();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        doService(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        doService(request, response);
    }

    public void doService(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        String userId = request.getParameter("userid");
        String password = request.getParameter("password");
        String btnAction = request.getParameter("btnAction");

        writelogline("before logging");

        if (btnAction.equalsIgnoreCase("log on"))
        {
            writelogline("logging in");
            this.getState().login(userId, password);
        }
        else if (btnAction.equalsIgnoreCase("log out"))
        {
            writelogline("logging out");
            this.getState().logout();
        }
        response.sendRedirect(this.getState().getNextPage());
    }

    public UserState getState()
    {
        return userState.getCurrentState();
    }

    private static void writelogline(String msg)
    {
        System.out.println(msg);
    }

}
