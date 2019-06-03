import database.DBConnector;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class JobRunner {
    DBConnector myDBConnector = new DBConnector();
    Connection conn = myDBConnector.getConn();

    public void getTruckers() throws SQLException {



        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM trucking");

        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }

        System.out.println("Get Truckers called");
    }

    public int getNewID() throws SQLException {
        int nextID = -1;

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT MAX(id_job) AS NEXT_ID FROM trucking");

//        System.out.println(rs.getInt("NEXT_ID"));

        while (rs.next()) {
            nextID = rs.getInt("NEXT_ID");
        }
        return nextID + 1;
    }

    public Job createJob(Job job) throws SQLException, SQLSyntaxErrorException {
//        Connection conn = getConnection();

        java.sql.Date date = new java.sql.Date(0000 - 00 - 00);
        DateFormat dateFormatMDY = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//        Date now = new Date();
        String vDateMDY = dateFormatMDY.format(job.getDate());

        PreparedStatement createJobStatement = conn.prepareStatement("INSERT INTO trucking values (?, ?, ?, ?, ?, ?, ?)");
        createJobStatement.setInt(1, getNewID());
        createJobStatement.setString(2, job.getDriverName());
        createJobStatement.setInt(3, Integer.parseInt(job.getTruckNumber()));
        createJobStatement.setInt(4, Integer.parseInt(job.getTrailerNumber()));
        createJobStatement.setString(5, job.getStartLocation());
        createJobStatement.setString(6, job.getEndLocation());
        createJobStatement.setDate(7, new java.sql.Date(System.currentTimeMillis()));

        System.out.println(createJobStatement);

        int n = createJobStatement.executeUpdate();


        System.out.println("Number of rows affected " + n);
        return null;
    }

    public Job deleteJob(int jobID) throws SQLException, SQLSyntaxErrorException {
//        Connection conn = getConnection();

        PreparedStatement deleteJobStatement = conn.prepareStatement("DELETE FROM trucking WHERE id_job = ?");
        deleteJobStatement.setInt(1, jobID);
        System.out.println(deleteJobStatement);

        int n = deleteJobStatement.executeUpdate();


        System.out.println("Number of rows affected " + n);
        return null;
    }

    public Job updateJob(Job job) throws SQLException, SQLSyntaxErrorException {
//        Connection conn = getConnection();

        PreparedStatement updateJobStatement = conn.prepareStatement("UPDATE trucking SET name = ? , truck_number = ?, trailer_number = ?, start_address = ?, end_address = ?, date = ? WHERE id_trucker = ?");
        updateJobStatement.setString(1, job.getDriverName());
        updateJobStatement.setInt(2, Integer.parseInt(job.getTruckNumber()));
        updateJobStatement.setInt(3, Integer.parseInt(job.getTrailerNumber()));
        updateJobStatement.setString(4, job.getStartLocation());
        updateJobStatement.setString(5, job.getEndLocation());
        updateJobStatement.setDate(6, new java.sql.Date(System.currentTimeMillis()));
        updateJobStatement.setInt(7, job.getId());

        System.out.println(updateJobStatement);

        int n = updateJobStatement.executeUpdate();


        System.out.println("Number of rows affected " + n);
        return null;
    }

    public static void main(String[] args) {

        // First test to try out the Job class.


//        System.out.println("Creating a new job");
//        Job nextJob = new Job("Rob","14","64","Tampa, FL", "Chesterfield, MO", new java.sql.Date(System.currentTimeMillis()));
//        System.out.println(nextJob.getDriverName() + " " + nextJob.getEndLocation());
//        System.out.println("Finished creating a new job");


        // Second test out the Connection

//        try {
            JobRunner newJR = new JobRunner();
            newJR.myDBConnector.getConn();
        System.out.println("Connected!");
//        } catch () {
//            System.out.println(e.getErrorCode());
//            e.printStackTrace();
//        }
//
//
//        // Third test to list truckers
//
//        try {
//            newJR.getTruckers();
//        } catch (SQLException e) {
//            System.out.println(e.getErrorCode());
//            e.printStackTrace();
//        }
//
//
//        // Fourth test to insert a new job
//
        try {
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
//        try {
//            int IdJob = 11;
//            newJR.deleteJob(IdJob);
//        } catch (SQLException e) {
//            System.out.println(e.getErrorCode());
//            e.printStackTrace();
//        }
//
//
//        // Sixth test to update a full record
//        try {
//            myJob = new Job(10, "Dave", "16", "63", "Chicago, IL", "St. Louis, MO", new java.sql.Date(System.currentTimeMillis()));
//            newJR.updateJob(myJob);
//        } catch (SQLException e) {
//            System.out.println(e.getErrorCode());
//            e.printStackTrace();
//        }

    }
}

