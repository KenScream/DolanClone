package com.project.dolanaps;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Item");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new HomeFragment());


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, fragment).commit();
            return true;
        }

        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.home_id:
                fragment = new HomeFragment();
                break;
            case R.id.mybooking_id:
                fragment = new MyBookingFragment();
                break;
            case R.id.mymessage_id:
                fragment = new MyMessageFragment();
                break;
            case R.id.myprofile_id:
                fragment = new MyProfileFragment();
                break;


        }
        return loadFragment(fragment);
    }

    public void flightonclick(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, FlightActivity.class);
        startActivity(intent);
    }

    public void busonclick(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, BusActivity.class);
        startActivity(intent);
    }

    public void hotelonclick(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, HotelActivity.class);
        startActivity(intent);
    }

    public void restonclick(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, RestaurantActivity.class);
        startActivity(intent);
    }

    public void trainonclick(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, TrainActivity.class);
        startActivity(intent);
    }

}
//    public Boolean onNavigationItemSelected(MenuItem item){
//            int id =item.getItemId();
//            if(id ==R.id.bottom_navigation_bar){
//            FragmentManager manager = getSupportFragmentManager();
//            manager.beginTransaction()
//                    .add(R.id.home_fragment, new HomeFragment())
//                    .addToBackStack("fragment")
//                    .commit();
//            getSupportActionBar().getTitle("Home Fragment");
//        }
//        @SuppressLint("WrongViewCast") DrawerLayout drawer = (DrawerLayout) findViewById(R.id.home_fragment);
//            drawer.closeDrawer(GravityCompat.START);
//            return true;
//    }

//}



//    // load fragment
//    private boolean loadFragment(Fragment fragment){
//        if (fragment != null){
//            getSupportFragmentManager().beginTransaction().replace(fl_container,fragment).commit();
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public boolean onNavigationItemSelected() {
//        return onNavigationItemSelected();
//    }
//
//    @Override
//    public boolean onNavigationItemSelected( MenuItem menuItem) {
//        Fragment fragment = null;
//        switch (menuItem.getItemId()) {
//            case R.id.home_id:
//                fragment = new HomeFragment();
//                break;
//            case R.id.mybooking_id:
//                fragment = new MyBookingFragment();
//                break;
//            case R.id.mymessage_id:
//                fragment = new MyMessageFragment();
//                break;
//            case  R.id.myprofile_id:
//                fragment = new MyProfileFragment();
//                break;
//
//        }
//        return loadFragment(fragment);
//    }
//}