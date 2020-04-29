package com.example.wego;

import java.lang.reflect.Array;
import java.util.ArrayList;

import entity.Ride;
import wegoconstant.WegoConstatns;

public class DummyData {
    public static ArrayList<Ride> rideList = new ArrayList<Ride>();
    public static ArrayList<Ride> myDriveList = new ArrayList<Ride>();
    public static ArrayList<Ride> myRideList = new ArrayList<Ride>();

    static {
        addRide();
    }
    public static void addRide(){
        rideList.add(new Ride(1, "Narayan", "120 Lilac St, Syracuse, NY", "129 Lancet, Oswego, NY", "4/21/20", "8:00 AM", WegoConstatns.rideStatus.NEW));
        rideList.add(new Ride(2, "Alex", "121 Lilac St, Syracuse, NY", "128 Lancet, Oswego, NY", "4/22/20", "8:00 AM",WegoConstatns.rideStatus.NEW));
        rideList.add(new Ride(3, "Ryan", "122 Lilac St, Syracuse, NY", "127 Lancet, Oswego, NY", "4/23/20", "8:00 AM",WegoConstatns.rideStatus.NEW));
        rideList.add(new Ride(4, "Rick", "123 Lilac St, Syracuse, NY", "126 Lancet, Oswego, NY", "4/24/20", "8:00 AM",WegoConstatns.rideStatus.NEW));

    }

}
