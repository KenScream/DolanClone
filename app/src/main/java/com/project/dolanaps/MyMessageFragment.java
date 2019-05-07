package com.project.dolanaps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class MyMessageFragment extends Fragment {

    View view;
    Button myMessageButton;
    public MyMessageFragment() {

    }

    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        view = inflater.inflate(R.layout.fragment_my_booking,container,false);
//        myMessageButton = (Button) view.findViewById(R.id.mymessage_id);
//        myMessageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(),"My Message",Toast.LENGTH_LONG).show();
//            }
//        });
//        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_message, container, false);
        return view;
    }

}
