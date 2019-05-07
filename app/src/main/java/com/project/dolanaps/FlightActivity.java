package com.project.dolanaps;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebStorage;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;

public class FlightActivity extends AppCompatActivity {
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight);


        Spinner dropdown  = findViewById(R.id.spinnerOry);
        Spinner dropdown1  = findViewById(R.id.spinnerDest);
        Spinner dropdown2  = findViewById(R.id.spinnerMas);

        final ArrayList<String> itemsOry = new ArrayList<>();
        itemsOry.add("Pilih Keberangkatan");

        final ArrayList<String> itemsDest = new ArrayList<>();
        itemsDest.add("Pilih Tujuan");

        final ArrayList<String> itemsMas = new ArrayList<>();
        itemsMas.add("Pilih Maskapai");

        //push item dropdown from firebase
        mDatabase.child("Item/Flight").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                itemsOry.add((String) dataSnapshot.child("Origin").getValue());
                itemsDest.add((String) dataSnapshot.child("Destination").getValue());
                itemsMas.add(dataSnapshot.getKey());

                //validasi
                for (int i = 0; i < itemsOry.size(); i++) {
                    for (int j = i + 1; j < itemsOry.size(); j++) {
                        if (itemsOry.get(i).equals(itemsOry.get(j))) {
                            itemsOry.remove(j);
                            j=i;
                        }
                    }
                }


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        // END push item dropdown from firebase

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,itemsOry);
        dropdown.setAdapter(adapter);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,itemsDest);
        dropdown1.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,itemsMas);
        dropdown2.setAdapter(adapter2);


        Button search = findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner s = findViewById(R.id.spinnerOry);
                String Ory = s.getSelectedItem().toString();

                Spinner s1 = findViewById(R.id.spinnerDest);
                String Dest = s1.getSelectedItem().toString();

                Spinner s2 = findViewById(R.id.spinnerMas);
                String Mas = s2.getSelectedItem().toString();

                mDatabase.child("Item/Andy/Flight").setValue(Mas);
                mDatabase.child("Item/Andy/Flight/Destination").setValue(Dest);
                mDatabase.child("Item/Andy/Agus/Flight/Origin").setValue(Ory);



            }
        });
    }

    public void showDatePicker(View view) {
        DialogFragment dialog = new DatePickerFragment();
        dialog.show(this.getSupportFragmentManager(),"datepicker");
    }

    public void processDataPickerResult(int year, int month, int day){
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string +"/"+day_string+"/"+year_string);

        Toast.makeText(this, dateMessage,Toast.LENGTH_SHORT).show();
    }
}
