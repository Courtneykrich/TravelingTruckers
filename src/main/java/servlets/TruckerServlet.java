package servlets;

import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.*;
import database.DBConnector;

public class TruckerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        PrintWriter writer = resp.getWriter();

        ResultSet resultSet = null;
        Statement statement = null;
        try {
            Connection conn = new DBConnector().getConn();
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT name FROM trucking");
            writer.print("Hello, ");
            while (resultSet.next()){
                System.out.println(resultSet.getString("name"));
                writer.print(resultSet.getString("name")+", ");
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            e.printStackTrace();
        }finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                }catch (SQLException sqlEx){
                    System.out.println(sqlEx);
                }
            }
            if (statement != null){
                try{
                    statement.close();
                }catch (SQLException sqlEx){
                    System.out.println(sqlEx);
                }
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer =resp.getWriter();

        PreparedStatement statement = null;
        String sql = "INSERT INTO trucking (name)VALUES(?)";
        String name = req.getParameter("trucker_name");


        try {
            Connection conn = new DBConnector().getConn();
            statement= conn.prepareStatement(sql);
            statement.setString(1,name);
            int i = statement.executeUpdate();
            writer.print(i+" records inserted");
        }catch (SQLException e){
            System.out.println(e.getErrorCode());
            e.printStackTrace();
        }
    }
}
