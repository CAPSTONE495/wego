package com.example.wego.ui.Drive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wego.DummyData;
import com.example.wego.R;

import java.util.ArrayList;

import adapter.DriveAdapter;
import adapter.RideAdapter;
import entity.Ride;
import wegoconstant.WegoConstatns;

public class DriveFragment extends Fragment {

    RecyclerView recyclerView;
    private DriveAdapter rideAdapter;
    ArrayList<Ride> lsitOfRides;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_drive, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.driveRecyclerView);
        recyclerView.setTag(WegoConstatns.recyclerViewDrive);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        lsitOfRides = DummyData.myDriveList;
        rideAdapter = new DriveAdapter(lsitOfRides, recyclerView);
        recyclerView.setAdapter(rideAdapter);
        return root;
    }
}