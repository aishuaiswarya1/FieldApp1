package com.example.fieldaware;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.fieldaware.databinding.ActivityDatetimeBinding;
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

public class datetime extends AppCompatActivity {
    private DatabaseReference reference;
    ActivityDatetimeBinding binding;
    String date;
    int counter = 0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDatetimeBinding.inflate(getLayoutInflater(), null, false);
        setContentView(binding.getRoot());
        reference = FirebaseDatabase.getInstance().getReference("Date");
 binding.pickDate.setOnClickListener(new View.OnClickListener() {
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        pickData();
    }
});
binding.shareDate.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (date != null) {
            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    counter = (int) snapshot.getChildrenCount();
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
            reference.child("date_time" + (counter + 1)).setValue(date);
            startActivity(new Intent(getApplicationContext(),Engineer.class));
        }
    }
});
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void pickData() {
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy h:mm a");
        String date = df.format(Calendar.getInstance().getTime());
        this.date = date;
        binding.textView.setText(date);
    }
}


