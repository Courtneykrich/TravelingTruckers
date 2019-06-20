package database;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class JobRunner {
    private DBConnector myDBConnector = new DBConnector();
//    Connection conn = myDBConnector.getConn();

    public void getTruckers() throws SQLException {
        Connection conn = myDBConnector.getConn();

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM trucking");

        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }

        System.out.println("Get Truckers called");

        rs.close();
        st.close();

    }

    public int getNewID() throws SQLException {
        int nextID = -1;
        Connection conn = myDBConnector.getConn();

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT MAX(id_job) AS NEXT_ID FROM trucking");

        while (rs.next()) {
            nextID = rs.getInt("NEXT_ID");
        }

        return nextID + 1;

    }

    public Job createJob(Job job) throws SQLException, SQLSyntaxErrorException {
        Connection conn = myDBConnector.getConn();

        java.sql.Date date = new java.sql.Date(0000 - 00 - 00);
        DateFormat dateFormatMDY = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        String vDateMDY = dateFormatMDY.format(job.getDate());

        PreparedStatement createJobStatement = conn.prepareStatement("INSERT INTO trucking values (?, ?, ?, ?, ?, ?, ?)");
        createJobStatement.setInt(1, getNewID());
        createJobStatement.setString(2, job.getDriverName());
        createJobStatement.setString(3, job.getTruckNumber());
        createJobStatement.setString(4, job.getTrailerNumber());
        createJobStatement.setString(5, job.getStartLocation());
        createJobStatement.setString(6, job.getEndLocation());
        createJobStatement.setDate(7, new java.sql.Date(System.currentTimeMillis()));

        System.out.println(createJobStatement);

        createJobStatement.executeUpdate();

        createJobStatement.close();


        return null;
    }

    public Job deleteJob(int jobID) throws SQLException, SQLSyntaxErrorException {
        Connection conn = myDBConnector.getConn();

        PreparedStatement deleteJobStatement = conn.prepareStatement("DELETE FROM trucking WHERE id_job = ?");
        deleteJobStatement.setInt(1, jobID);
        System.out.println(deleteJobStatement);

        deleteJobStatement.executeUpdate();

        deleteJobStatement.close();


        return null;
    }

    public Job updateJob(Job job) throws SQLException, SQLSyntaxErrorException {
        Connection conn = myDBConnector.getConn();

        PreparedStatement updateJobStatement = conn.prepareStatement("UPDATE trucking SET name = ? , truck_number = ?, trailer_number = ?, start_address = ?, end_address = ?, date = ? WHERE id_job = ?");
        updateJobStatement.setString(1, job.getDriverName());
        updateJobStatement.setInt(2, Integer.parseInt(job.getTruckNumber()));
        updateJobStatement.setInt(3, Integer.parseInt(job.getTrailerNumber()));
        updateJobStatement.setString(4, job.getStartLocation());
        updateJobStatement.setString(5, job.getEndLocation());
        updateJobStatement.setDate(6, new java.sql.Date(System.currentTimeMillis()));
        updateJobStatement.setInt(7, job.getId());

        System.out.println(updateJobStatement);

        updateJobStatement.executeUpdate();

        updateJobStatement.close();


        return null;
    }

    public void testConnection(){
        myDBConnector.getConn();
    }
    public static void main(String[] args) {

        // First test to try out the database.Job class.


        System.out.println("Creating a new job");
        Job nextJob = new Job("Courtney", "8","95","Chesterfield, MO","Boston, MA" );
        System.out.println(nextJob.getDriverName() + " " + nextJob.getEndLocation());
        System.out.println("Finished creating a new job");


        // Second test out the Connection

        try {
            JobRunner newJR = new JobRunner();
            newJR.testConnection();
        System.out.println("Connected!");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
//
//
//        // Third test to list truckers
//
        try {
            JobRunner newJR= new JobRunner();
            newJR.getTruckers();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            e.printStackTrace();
        }
//
//
//        // Fourth test to insert a new job
//
        try {
            JobRunner newJR = new JobRunner();
           Job myJob = new Job(newJR.getNewID(), "Penny", "16", "89", "St. Paul,MN", "St. Louis", new java.sql.Date(System.currentTimeMillis()));
            newJR.createJob(myJob);
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            e.printStackTrace();
        }
//
//
//        // Fifth test to delete a record
//
        try {
            JobRunner delRunner = new JobRunner();
            int IdJob = 15;
            delRunner.deleteJob(IdJob);
            IdJob = 16;
            delRunner.deleteJob(IdJob);
            IdJob = 19;
            delRunner.deleteJob(IdJob);

        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            e.printStackTrace();
        }
//
//
//        // Sixth test to update a full record
        try {
            Job myJob= new Job(10, "Dave", "16", "63", "Chicago, IL", "St. Louis, MO", new java.sql.Date(System.currentTimeMillis()));
//            myJob = new database.Job(10, "Dave", "16", "63", "Chicago, IL", "St. Louis, MO", new java.sql.Date(System.currentTimeMillis()));
            JobRunner newJR = new JobRunner();
            newJR.updateJob(myJob);
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            e.printStackTrace();
        }

    }
}

