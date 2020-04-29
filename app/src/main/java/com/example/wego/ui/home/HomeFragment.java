package com.example.wego.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
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

import adapter.HomeAdapter;
import adapter.RideAdapter;
import entity.Ride;
import wegoconstant.WegoConstatns;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    private HomeViewModel homeViewModel;
    private ListView listView;
    private HomeAdapter rideAdapter;
    ArrayList<Ride> lsitOfRides;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        recyclerView.setTag(WegoConstatns.recyclerViewHome);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        lsitOfRides = DummyData.rideList;
        rideAdapter = new HomeAdapter(lsitOfRides, recyclerView);
        recyclerView.setAdapter(rideAdapter);
        return root;
    }
}