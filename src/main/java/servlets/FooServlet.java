package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FooServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("action"));
        String action = req.getParameter("action");

        switch (action) {
            case "list":
                http://localhost:8080/foo?action=list
                System.out.println("do the get truckers java code");
                break;
            case "delete":
                // http://localhost:8080/foo?action=delete&id=7
                String jobID = req.getParameter("id");
                System.out.println("do the delete trucker with id: " + jobID);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req);
    }
}
