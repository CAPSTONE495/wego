package entity;

import android.location.Location;

public class Ride {
    int id;
    String driver;
    String where;
    String from;
    String date;
    String time;
    Enum status;

    public Ride(int id, String driver, String where, String from, String date, String time, Enum status){
        this.id = id;
        this.driver = driver;
        this.where = where;
        this.from = from;
        this.date = date;
        this.time = time;
        this.status = status;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDriver(){return driver;}

    public void setDriver(String driver){this.driver = driver;}

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

}
