package com.example.fieldaware;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.airbnb.lottie.L;
import com.example.fieldaware.databinding.ActivityDatetimeBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateTime extends AppCompatActivity {

    private static final int REQUEST_LOCATION = 1;
    ActivityDatetimeBinding binding;
    public static String date;
    int counter = 0;

    public static String deviceId;
    DatabaseReference databaseReference;
    //    FirebaseDatabase firebaseDatabase;
    FusedLocationProviderClient fusedLocationProviderClient;
    private static final String TAG = "DateTime";
    FusedLocationProviderClient mFusedLocationClient;


    int PERMISSION_ID = 44;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDatetimeBinding.inflate(getLayoutInflater(), null, false);
        setContentView(binding.getRoot());


        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    getLastLocation();
    }

    @SuppressLint("MissingPermission")
    private void getLastLocation() {

        if (checkPermissions()) {

            if (isLocationEnabled()) {


                mFusedLocationClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        Location location = task.getResult();
                        if (location == null) {
                            requestNewLocationData();
                        } else {
                          binding.latTextView.setText(location.getLatitude() + "");
                            binding.lonTextView.setText(location.getLongitude() + "");
                        }
                    }
                });
            } else {
                Toast.makeText(this, "Please turn on" + " your location...", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        } else {
            // if permissions aren't available,
            // request for permissions
            requestPermissions();
        }
    }

    @SuppressLint("MissingPermission")
    private void requestNewLocationData() {

        // Initializing LocationRequest
        // object with appropriate methods
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(5);
        mLocationRequest.setFastestInterval(0);
        mLocationRequest.setNumUpdates(1);

        // setting LocationRequest
        // on FusedLocationClient
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper());
    }

    private LocationCallback mLocationCallback = new LocationCallback() {

        @Override
        public void onLocationResult(LocationResult locationResult) {
            Location mLastLocation = locationResult.getLastLocation();
            binding.latTextView.setText("Latitude: " + mLastLocation.getLatitude() + "");
            binding.lonTextView.setText("Longitude: " + mLastLocation.getLongitude() + "");
        }
    };

    // method to check for permissions
    private boolean checkPermissions() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;

        // If we want background location
        // on Android 10.0 and higher,
        // use:
        // ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    // method to request for permissions
    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_ID);
    }

    // method to check
    // if location is enabled
    private boolean isLocationEnabled() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    // If everything is alright then
    @Override
    public void
    onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_ID) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLastLocation();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (checkPermissions()) {
            getLastLocation();
        }


        binding.share.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                String latitude=binding.latTextView.getText().toString().trim();
                String longitude=binding.lonTextView.getText().toString().trim();
                deviceId = binding.deviceId.getEditText().getText().toString().trim();
                if (TextUtils.isEmpty(deviceId))
                    binding.deviceId.setError("Empty Field");
                else {
                    binding.deviceId.setError("");
                    shareDetails();
                    Intent intent=new Intent(DateTime.this,Engineer.class);
                    startActivity(intent);
                }

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void shareDetails() {
        getLastLocation();
        String latitude=binding.latTextView.getText().toString().trim();
        String longitude=binding.lonTextView.getText().toString().trim();
        deviceId = binding.deviceId.getEditText().getText().toString().trim();
String device=binding.deviceId.getEditText().getText().toString().trim();
        if(
        !deviceId.isEmpty()
){
    date = pickDate();
}
        DeviceID deviceID = new DeviceID(  latitude,  longitude);
        databaseReference = FirebaseDatabase.getInstance().getReference("cp_serial_no");
        databaseReference.child(deviceId).child(date).setValue(deviceID).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                binding.deviceId.getEditText().setText("");
binding.lonTextView.setText("");
binding.latTextView.setText("");
            }
        });

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public String pickDate() {
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy h:mm a");
        String date = df.format(Calendar.getInstance().getTime());
        String fDate = date.replace(",", "");
        String formattedDate = fDate.replaceAll("[^a-zA-Z0-9]", "_");
        //      this.date = formattedDate;
        // binding.textView.setText(this.date);
        return formattedDate;
    }
}