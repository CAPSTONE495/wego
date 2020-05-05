package com.example.wego.ui.Drive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wego.DummyData;
import com.example.wego.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import adapter.DriveAdapter;
import adapter.RideAdapter;
import entity.Ride;
import wegoconstant.WegoConstatns;

public class DriveFragment extends Fragment {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

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
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        ActionBar actionbar = activity.getSupportActionBar();
        dl = (DrawerLayout)root.findViewById(R.id.activity_home);
        t = new ActionBarDrawerToggle(getActivity(), dl,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        dl.addDrawerListener(t);
        t.syncState();

        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setHomeButtonEnabled(true);
        nv = (NavigationView)root.findViewById(R.id.nv);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.account:
                        Toast.makeText(getActivity(), "My Account",Toast.LENGTH_SHORT).show();break;
                    case R.id.settings:
                        Toast.makeText(getActivity(), "Settings",Toast.LENGTH_SHORT).show();break;
                    case R.id.mycart:
                        Toast.makeText(getActivity(), "My Cart",Toast.LENGTH_SHORT).show();break;
                    default:
                        return true;
                }


                return true;

            }
        });

        return root;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}