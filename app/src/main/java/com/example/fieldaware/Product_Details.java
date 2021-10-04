package com.example.fieldaware;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import com.example.fieldaware.databinding.ActivityCustdetailsBinding;
import com.example.fieldaware.databinding.ActivityProductDetailsBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;

public class Product_Details extends AppCompatActivity {
    DatabaseReference databaseReference;
    Product_info product_info;
    int i = 0;
    ActivityProductDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater(), null, false);
        setContentView(binding.getRoot());
        product_info = new Product_info();
        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (binding.radioGroup.getCheckedRadioButtonId()) {
                    case R.id.envitus_radiobutton:
                        binding.envitusView.setVisibility(View.VISIBLE);
                        binding.LinearLayout.setVisibility(View.VISIBLE);
                        binding.timsView.setVisibility(View.GONE);
                        break;
                    case R.id.tims_radiobutton:
                        binding.timsView.setVisibility(View.VISIBLE);
                        binding.envitusView.setVisibility(View.GONE);
                        binding.soilView.setVisibility(View.GONE);
                        binding.waterView.setVisibility(View.GONE);
                        binding.airView.setVisibility(View.GONE);
                        binding.awsView.setVisibility(View.GONE);
                        binding.floodView.setVisibility(View.GONE);
                     binding.awsradiogrp.setVisibility(View.GONE);
                        break;

                }
            }
        });
        binding.awsradiogrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.aws_button:
                        binding.awsgrp.setVisibility(View.VISIBLE);
                        binding.floodView.setVisibility(View.GONE);
                        break;
                    case R.id.floodt_button:
                        binding.awsgrp.setVisibility(View.GONE);
                        binding.floodView.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
        binding.Familygrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (binding.Familygrp.getCheckedRadioButtonId()) {
                    case R.id.air_button:
                        binding.airView.setVisibility(View.VISIBLE);
                        binding.habitatView.setVisibility(View.GONE);
                        binding.soilView.setVisibility(View.GONE);
                        binding.waterView.setVisibility(View.GONE);
                        binding.awsgrp.setVisibility(View.GONE);
                        break;
                    case R.id.habitat_button:
                        binding.habitatView.setVisibility(View.VISIBLE);
                        binding.airView.setVisibility(View.GONE);
                        binding.soilView.setVisibility(View.GONE);
                        binding.waterView.setVisibility(View.GONE);

                        break;
                    case R.id.soil_button:
                        binding.soilView.setVisibility(View.VISIBLE);
                        binding.habitatView.setVisibility(View.GONE);
                        binding.airView.setVisibility(View.GONE);
                        binding.waterView.setVisibility(View.GONE);
                        binding.awsgrp.setVisibility(View.GONE);
                        break;
                    case R.id.water_button:
                        binding.waterView.setVisibility(View.VISIBLE);
                        binding.airView.setVisibility(View.GONE);
                        binding.habitatView.setVisibility(View.GONE);
                        binding.soilView.setVisibility(View.GONE);
                        binding.awsgrp.setVisibility(View.GONE);
                        break;
                }

            }
        });
        databaseReference = FirebaseDatabase.getInstance().getReference("cp_serial_no");
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.exists()) {
//                    i = (int) snapshot.getChildrenCount();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String envitus = binding.envitusRadiobutton.getText().toString().trim();
                String tims = binding.timsRadiobutton.getText().toString().trim();
                String air = binding.airButton.getText().toString().trim();
                String habitat = binding.habitatButton.getText().toString().trim();
                String water = binding.waterButton.getText().toString().trim();
                String soil = binding.soilButton.getText().toString().trim();
                String indoor = binding.indoorButton.getText().toString().trim();
                String ambient = binding.ambientButton.getText().toString().trim();
                String aws = binding.awsButton.getText().toString().trim();
                String flood = binding.farmButton.getText().toString().trim();
                String residential = binding.residentialButton.getText().toString().trim();
                String farm = binding.farmButton.getText().toString().trim();
                String domestic = binding.domesticButton.getText().toString().trim();
                String agriculture = binding.agrbutton.getText().toString().trim();
                String research = binding.researchButton.getText().toString().trim();
                if (binding.envitusRadiobutton.isChecked()) {
//                    product_info.setBrand(envitus);
//                    databaseReference.child(DateTime.deviceId).child(DateTime.date).child(envitus).setValue(product_info);

                    databaseReference.child(DateTime.deviceId).child(DateTime.date).child("product").child("brand").setValue(envitus).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull @NotNull Task<Void> task) {
                            if(task.isSuccessful()) {
                                //Toast.makeText(Product_Details.this, "Data stored", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    product_info.setBrand(tims);
                    databaseReference.child(DateTime.deviceId).child(DateTime.date).child("product").child("brand").setValue(tims);
                }
                switch (binding.Familygrp.getCheckedRadioButtonId()) {
                    case R.id.air_button:

                        databaseReference.child(DateTime.deviceId).child(DateTime.date).child("product").child("family").setValue(air).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                            }
                        });
                        break;
                    case R.id.habitat_button:
                        databaseReference.child(DateTime.deviceId).child(DateTime.date).child("product").child("family").setValue(habitat).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                            }
                        });
                        break;
                    case R.id.soil_button:

                        databaseReference.child(DateTime.deviceId).child(DateTime.date).child("product").child("family").setValue(soil).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                            }
                        });

                        break;
                    case R.id.water_button:
                        databaseReference.child(DateTime.deviceId).child(DateTime.date).child("product").child("family").setValue(water).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                            }
                        });
                }

                if (binding.ambientButton.isChecked()) {
                    databaseReference.child(DateTime.deviceId).child(DateTime.date).child("product").child("family_sub1").setValue(ambient).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                        }
                    });
                }
                        if (binding.indoorButton.isChecked()) {

                        databaseReference.child(DateTime.deviceId).child(DateTime.date).child("product").child("family_sub1").setValue(indoor).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                            }
                        });

                        }
                        switch (binding.awsradiogrp.getCheckedRadioButtonId()) {
                            case R.id.aws_button:
                                databaseReference.child(DateTime.deviceId).child(DateTime.date).child("product").child("family_sub1").setValue(aws).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {

                                    }
                                });
                            case R.id.floodt_button:

                                databaseReference.child(DateTime.deviceId).child(DateTime.date).child("product").child("family_sub1").setValue(flood).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {

                                    }
                                });
                        }
                       switch (binding.awsgrp.getCheckedRadioButtonId()){
                           case R.id.agrbutton:
                        databaseReference.child(DateTime.deviceId).child(DateTime.date).child("product").child("family_sub2").setValue(agriculture).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                            }
                        });
                           case R.id.research_button:
                        databaseReference.child(DateTime.deviceId).child(DateTime.date).child("product").child("family_sub2").setValue(research).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                            }
                        });
                        }


                        if (binding.residentialButton.isChecked()) {
                        databaseReference.child(DateTime.deviceId).child(DateTime.date).child("product").child("family_sub2").setValue(residential).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                            }
                        });
                        }
                        if (binding.farmButton.isChecked()) {
                        databaseReference.child(DateTime.deviceId).child(DateTime.date).child("product").child("family_sub1").setValue(farm).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                            }
                        });
                        }
                        if (binding.domesticButton.isChecked()) {
                        databaseReference.child(DateTime.deviceId).child(DateTime.date).child("product").child("family_sub1").setValue(domestic).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                            }
                        });
                }

            }

        });
    }
}
