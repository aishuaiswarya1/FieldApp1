package com.example.fieldaware;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fieldaware.databinding.ActivityEngineerBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Engineer extends AppCompatActivity {
    ActivityEngineerBinding binding;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEngineerBinding.inflate(getLayoutInflater(), null, false);
        setContentView(binding.getRoot());
binding.skip.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(),CustDetails.class));
    }
});
        binding.b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createengineer();
            }
        });
    }
    private void createengineer() {
        String name = binding.e1.getEditText().getText().toString().trim();
        String emp_id = binding.e2.getEditText().getText().toString().trim();
        String email_id = binding.e3.getEditText().getText().toString().trim();
        if (email_id.isEmpty()) {
            binding.e3.setError("Field can not be empty");
        }
        if (name.isEmpty()) {
            binding.e1.setError("Field can not be empty");
        }
        if (emp_id.isEmpty()) {
            binding.e2.setError("Field can not be empty");
        }
        if (!name.isEmpty() && !email_id.isEmpty() && !emp_id.isEmpty()) {
            AddEng addeng = new AddEng(email_id, name, emp_id);
            firebaseDatabase = FirebaseDatabase.getInstance();
            databaseReference = firebaseDatabase.getReference("cp_serial_no");
            databaseReference.child(DateTime.deviceId).child(DateTime.date).child(emp_id).setValue(addeng).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    binding.e1.getEditText().setText("");
                    binding.e2.getEditText().setText("");
                    binding.e3.getEditText().setText("");
                    startActivity(new Intent(getApplicationContext(), CustDetails.class));
                }
            });
        }
    }
}