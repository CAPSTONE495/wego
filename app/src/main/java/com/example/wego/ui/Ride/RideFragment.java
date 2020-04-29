package com.example.wego.ui.Ride;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wego.DummyData;
import com.example.wego.R;

import java.util.ArrayList;

import adapter.RideAdapter;
import entity.Ride;
import wegoconstant.WegoConstatns;

public class RideFragment extends Fragment {

    private RideViewModel rideViewModel;

    RecyclerView recyclerView;
    private RideAdapter rideAdapter;
    ArrayList<Ride> lsitOfRides;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_drive, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.driveRecyclerView);
        recyclerView.setTag(WegoConstatns.recyclerViewRide);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        lsitOfRides = new ArrayList<Ride>();
        lsitOfRides = DummyData.myRideList;
        rideAdapter = new RideAdapter(lsitOfRides, recyclerView);
        recyclerView.setAdapter(rideAdapter);
        return root;
    }
}