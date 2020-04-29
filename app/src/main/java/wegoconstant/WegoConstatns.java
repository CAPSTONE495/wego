package wegoconstant;

public interface WegoConstatns {

    // Fragment tag
    String recyclerViewHome = "recyclerViewHome";
    String recyclerViewDrive = "recyclerViewDrive";
    String recyclerViewRide = "recyclerViewRide";

    // btn
    String request = "Request";
    String cancel = "Cancel";
    String pending = "Pending";
    String accept = "Accept";
    String approved = "Approved";
    String decline = "Decline";
    String declined = "Declined";

    // Ride status
    enum rideStatus{
        NEW,
        PENDING,
        ACCEPT
    }
}
