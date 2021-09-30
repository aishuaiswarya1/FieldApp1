package com.example.fieldaware;

import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fieldaware.databinding.ActivityProfileBinding;
import com.example.fieldaware.databinding.FragmentProfileBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class ProfileFragment extends Fragment {

    public ProfileFragment() {
    }

    FirebaseDatabase firebasedatabase;
    FirebaseAuth firebaseAuth;

    TextView edit, employeid, company, mobile_number, email;
    ImageView imageView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        edit = view.findViewById(R.id.edit);
        employeid = view.findViewById(R.id.employeid);
        company = view.findViewById(R.id.company);
        mobile_number = view.findViewById(R.id.mobile_number);
        email = view.findViewById(R.id.email);
        imageView = view.findViewById(R.id.imageView);

        firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()!=null) {
            email.setText(firebaseAuth.getCurrentUser().getEmail());
        }

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }
}

