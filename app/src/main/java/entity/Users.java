package entity;

public class Users {
    private String id;
    String firstname;
    String lastname;
    String grade;
    String email;
    boolean driver;
    boolean admin;
    int num_seats;
    int rides_taken;
    int passenger_taken;
    double distance_traveled;
    double total_time;//this value represents the time for all the rides

    public Users(String firstname,String lastname, String email) {
        super();
        this.firstname = firstname;//TODO you can set first and last name to "" as they will be added at a later time
        this.lastname = lastname;
        this.email = email;
        //TODO I add some initilizers for when a new user is made. Please double check that this is fine.
        this.driver=false;
        this.admin=false;
        this.num_seats = 0;
        this.rides_taken = 0;
        this.passenger_taken = 0;
        this.distance_traveled=0;
        this.total_time=0;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getfirstName() {
        return firstname;
    }

    public void setfirstName(String fname) {
        this.firstname = fname;
    }

    public String getlastName() {
        return firstname;
    }

    public void setlastname(String lname) {
        this.lastname = lname;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getAdminStatus() {
        return admin;
    }

    public void setAdminStatus(boolean isAdmin) {
        this.admin = isAdmin;
    }

    public boolean getDriverStatus() {
        return driver;
    }

    public void setDriverStatus(boolean isDriver) {
        this.driver = isDriver;
    }

    public int getSeats() {
        return num_seats;
    }

    public void setSeats(int seats) {
        num_seats = seats;
    }

    public int getRidesTaken() {
        return rides_taken;
    }

    public void setRidesTaken(int rides) {
        rides_taken = rides;
    }

    public int getPassengerTaken() {
        return passenger_taken;
    }

    public void setPassengerTaken(int passenger) {
        passenger_taken = passenger;
    }

    public double getDistanceTraveled() {
        return distance_traveled;
    }


    public void setDistanceTraveled(int distance) {
        distance_traveled = distance;
    }

    public double getTotalTime() {
        return total_time;
    }

    public void setTotalTime(int total) {
        total_time = total;
    }

}
