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

        // read user and password introduced by the user in the UI
        String user = request.getParameter("u");
        String passwd = request.getParameter("p");

        // static & simulated db row
        final String dbu="ionel";
        final String dbp="anaaremere";
        final String userid="356";


        // version 2
        // pls notice both the user and password are submitted in the address bar, is this correct?
        // TASK: fix it

        // version 3
        // let's imagine the row is actually part of a list of users
        // (  (user1,password1,id1)(user2,password2,id2)(user3,password3, id3).... )
        // TASK: change the implementation above in such a way that the user and password read from UI is compared against
        // the content of a collection


        // version 4

        // TASK: read this from a real db:
        // a) select user,password from dbuser
        // b) put the result set in the collection created at version 2
        // c) iterate and compare



        // version 5
        // the UI and the usability is so ugly
        // TASK: pls fix the UI and the usability by adding some css classes


        if(dbu.equals(user) && dbp.equals(passwd)) {
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
