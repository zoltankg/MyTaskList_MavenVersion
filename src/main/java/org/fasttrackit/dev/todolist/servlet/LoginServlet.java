package org.fasttrackit.dev.todolist.servlet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by condor on April 04, 2015
 * FastTrackIT, 2015
 */


/* didactic purposes

Some items are intentionally not optimized or not coded in the right way

FastTrackIT 2015

*/

public class LoginServlet extends HttpServlet {



    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("MERGE");

        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        //HttpSession session = request.getSession(true);

        final String dbuser = "zoltan";
        final String dbpass = "1234";

        if(dbuser.equals(user) && dbpass.equals(pass)){

            HttpSession session = request.getSession(true);
            session.setAttribute("username", "orice");

            String success = "/todolist.html";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(success);
            dispatcher.forward(request, response);

        }
        else {
            System.out.println("nu exista acest user");
            String back = "/login.html";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(back);
            dispatcher.forward(request, response);
        }

    }





    /**/
    private void returnJsonResponse(HttpServletResponse response, String jsonResponse) {
        response.setContentType("application/json");
        PrintWriter pr = null;
        try {
            pr = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert pr != null;
        pr.write(jsonResponse);
        pr.close();
    }
}
