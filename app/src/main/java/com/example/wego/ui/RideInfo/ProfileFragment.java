package com.example.wego.ui.RideInfo;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.wego.Home;
import com.example.wego.MainActivity;
import com.example.wego.R;
import com.example.wego.ui.Drive.DriveFragment;

import wegoconstant.WegoConstatns;

public class ProfileFragment extends Fragment {

    private ProfileViewModel mViewModel;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.profile_fragment, container, false);
        Button btn = (Button) root.findViewById(R.id.backButton);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                System.out.println("Bingo Dingo Gu Singo");
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction tr = fm.beginTransaction();
                if(fm.getBackStackEntryCount()>0) {
                    fm.popBackStack();
                }
                //                getActivity().getSupportFragmentManager().popBackStack();
            }
        });        return root;
    }


}
