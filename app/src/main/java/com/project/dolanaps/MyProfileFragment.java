package com.project.dolanaps;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyProfileFragment extends Fragment {

    View view;
    Button myprofileButton;


    public MyProfileFragment() {
        // Required empty public constructor
    }


    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);
        return view;
        //        view = inflater.inflate(R.layout.fragment_my_profile,container,false);
//        myprofileButton =(Button) view.findViewById(R.id.myprofile_id);
//        myprofileButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(),"My Profile",Toast.LENGTH_LONG).show();
//            }
//        });
//        // Inflate the layout for this fragment
//        return view;
    }

}
