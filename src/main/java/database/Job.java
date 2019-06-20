package database;

import java.sql.Date;

public class Job {
    private int id;
    private String driverName;
    private String truckNumber;
    private String trailerNumber;
    private String startLocation;
    private String endLocation;
    private Date date;

    public Job(String driverName, String truckNumber, String trailerNumber, String startLocation, String endLocation) {
        this.driverName = driverName;
        this.truckNumber = truckNumber;
        this.trailerNumber = trailerNumber;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
    }

    public Job(int id, String driverName, String truckNumber,
               String trailerNumber, String start, String endLocation, Date date) {
        this.id = id;
        this.driverName = driverName;
        this.truckNumber = truckNumber;
        this.trailerNumber = trailerNumber;
        this.startLocation = start;
        this.endLocation = endLocation;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }

    public String getTrailerNumber() {
        return trailerNumber;
    }

    public void setTrailerNumber(String trailerNumber) {
        this.trailerNumber = trailerNumber;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String start) {
        this.startLocation = start;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
