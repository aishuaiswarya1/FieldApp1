package com.example.fieldaware;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    private String family_name, brand_name, sub_family1, sub_family2;


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
        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAssignedCategory();

                product_info = new Product_info(family_name, sub_family1, sub_family2);

                databaseReference.child(DateTime.deviceId).child(DateTime.date).child("product").
                        child("brand").setValue(brand_name).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<Void> task) {
                        databaseReference.child(DateTime.deviceId).child(DateTime.date)
                                .child("product").child("family").setValue(product_info)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull @NotNull Task<Void> task) {
                                        if(task.isSuccessful()) {

                                        }
                                    }
                                });
                    }
                });
                startActivity(new Intent(getApplicationContext(),Home.class));

            }

        });
    }

    public void checkAssignedCategory() {

        String envitus = binding.envitusRadiobutton.getText().toString().trim();
        String tims = binding.timsRadiobutton.getText().toString().trim();
        String air = binding.airButton.getText().toString().trim();
        String habitat = binding.habitatButton.getText().toString().trim();
        String water = binding.waterButton.getText().toString().trim();
        String soil = binding.soilButton.getText().toString().trim();
        String indoor = binding.indoorButton.getText().toString().trim();
        String ambient = binding.ambientButton.getText().toString().trim();
        String aws = binding.awsButton.getText().toString().trim();
        String flood = binding.floodtButton.getText().toString().trim();
        String residential = binding.residentialButton.getText().toString().trim();
        String farm = binding.farmButton.getText().toString().trim();
        String domestic = binding.domesticButton.getText().toString().trim();
        String agriculture = binding.agrbutton.getText().toString().trim();
        String research = binding.researchButton.getText().toString().trim();

        if (binding.envitusRadiobutton.isChecked())
            brand_name = envitus;
        else
            brand_name = tims;

        if (binding.LinearLayout.getVisibility() == View.VISIBLE) {
            switch (binding.Familygrp.getCheckedRadioButtonId()) {
                case R.id.air_button:
                    family_name = air;
                    break;
                case R.id.water_button:
                    family_name = water;
                    break;
                case R.id.habitat_button:
                    family_name = habitat;
                    break;
                case R.id.soil_button:
                    family_name = soil;
                    break;
            }
        }

        if (binding.airView.getVisibility() == View.VISIBLE) {
            if (binding.ambientButton.isChecked()) {
                sub_family1 = ambient;
                sub_family2 = null;
            }
            else {
                sub_family1 = indoor;
                sub_family2 = null;
            }
        } else if (binding.habitatView.getVisibility() == View.VISIBLE) {
            if (binding.awsButton.isChecked()) {
                sub_family1 = aws;
                if(binding.agrbutton.isChecked()) {
                    sub_family2 = agriculture;
                } else
                    sub_family2 = research;
            }
            else {
                sub_family1 = flood;
                if (binding.residentialButton.isChecked())
                    sub_family2 = residential;
            }
        } else if(binding.soilView.getVisibility() == View.VISIBLE) {
            sub_family1 = farm;
            sub_family2 = null;
        }
        else {
            sub_family1 = domestic;
            sub_family2 = null;
        }
    }
}
