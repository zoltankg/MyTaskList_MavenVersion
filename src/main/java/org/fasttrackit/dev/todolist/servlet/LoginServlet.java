package org.fasttrackit.dev.todolist.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by condor on 04/04/15.
 * FastTrackIT, 2015
 */
public class LoginServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // db
        final String dbu="ionel";
        final String dbp="anaaremere";
        final String userid="356";

        // citesc din db select user,password from dbuser
        // pun result set-ul intr-o colectie de beanuri de tip user pasword


        String user = request.getParameter("u");
        String passwd = request.getParameter("p");

        if(dbu.equals(user) && dbp.equals(passwd)) { // itere in colectie si compar
            // userul exista in db



            HttpSession session = request.getSession(true);
            session.setAttribute("username",user);
            session.setAttribute("usernameid",userid);
            String success = "/todolist.html";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(success);
            dispatcher.forward(request, response);
        }
        else {
            System.out.println("nu exista acest user in db, deci nu fac nimic ");
            String back = "/login.html";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(back);
            dispatcher.forward(request, response);
        }

        System.out.println("login service called...");

    }
}
