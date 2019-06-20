package servlets;

import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

import database.DBConnector;
import database.Job;
import database.JobRunner;

public class TruckerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

     resp.setContentType("text/html");
     PrintWriter writer = resp.getWriter();
        writer.println("<html><body>");

        writer.println("This " +req.getParameter("customer")+" job has been added.");
        writer.println("<br></br>");
        writer.println("Expenses included: ");
        writer.println("<br></br>");
        String[] expenses = req.getParameterValues("expenses");
        for(String tempExp : expenses){
            writer.println(tempExp+" ");
        }
        writer.println("<br></br>");
        writer.println("Thanks, "+req.getParameter("driverName"));


        writer.println("</body></html>");










        ResultSet resultSet = null;
        Statement statement = null;
        try {
            Connection conn = new DBConnector().getConn();
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT name FROM trucking");
            writer.print("Hello, ");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
                writer.print(resultSet.getString("name") + ", ");
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException sqlEx) {
                    System.out.println(sqlEx);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException sqlEx) {
                    System.out.println(sqlEx);
                }
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException  {
        PrintWriter writer = resp.getWriter();
        //writer.println("You have gotten to Trucker");

        resp.setContentType("text/html");
        writer = resp.getWriter();
        writer.println("<html><body>");
        writer.println("<style>\n" +
                "body {background-color: powderblue;\n" +
                "        color: black;\n" +
                "        font-size: 24px;\n" +
                "        text-align: center;}\n" +
                "\n" +
                "</style>");

        writer.println("This " +req.getParameter("customer")+" job has been added.");
        writer.println("<br></br>");
        writer.println("Expenses included: ");
        writer.println("<br></br>");
        String[] expenses = req.getParameterValues("expenses");
        for(String tempExp : expenses){
            writer.println(tempExp+" ");
        }
        writer.println("<br></br>");
        writer.println("Thanks, "+req.getParameter("driverName"));


        writer.println("</body></html>");



        JobRunner runner = new JobRunner();

        String name = req.getParameter("driverName");
        String trk = req.getParameter("truckNumber");
        String trl = req.getParameter("trailerNumber");
        String startAdd = req.getParameter("startAddress");
        String endAdd = req.getParameter("endAddress");

        try {
            int id = runner.getNewID();
            Date date = new java.sql.Date(System.currentTimeMillis());
            runner.createJob(new Job(id,name,trk,trl,startAdd,endAdd,date));
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
