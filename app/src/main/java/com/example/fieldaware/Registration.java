package com.example.fieldaware;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;

import com.example.fieldaware.databinding.ActivityRegistrationBinding;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.ContentValues.TAG;

public class Registration extends AppCompatActivity {
    CircleImageView profile;
    FloatingActionButton fab;
    FirebaseAuth firebaseAuth;
 ActivityRegistrationBinding binding;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[@#$%^&+=])" +
                    "(?=\\S+$)" +
                    ".{4,}" +
                    "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater(), null, false);
        setContentView(binding.getRoot());
        firebaseAuth = FirebaseAuth.getInstance();
        binding.regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                createuser();
                startActivity(new Intent(getApplicationContext(),datetime.class));
            }
        });
    }
        private void createuser() {
            String emailid = binding.email.getText().toString().trim();
            String password = binding.pass.getText().toString().trim();
            String name = binding.name.getText().toString().trim();
            String phone = binding.mobile.getText().toString().trim();
            String eid=binding.eid.getText().toString().trim();
            String company = binding.company.getText().toString().trim();

            if (emailid.isEmpty()) {
                binding.email.setError("Field can not be empty");
            }
             if (name.isEmpty()) {
                binding.name.setError("Field can not be empty");}
             if (eid.isEmpty()) {
                binding.eid.setError("Field can not be empty");}
             if (company.isEmpty()) {
                binding.company.setError("Field can not be empty");}
             if (phone.isEmpty()) {
                binding.mobile.setError("Field can not be empty");}
             if (!Patterns.EMAIL_ADDRESS.matcher(emailid).matches()) {
                binding.email.setError("Please enter a valid email address");
            }  if (password.isEmpty()) {
                binding.pass.setError("Field can not be empty");
            }  if (!PASSWORD_PATTERN.matcher(password).matches()) {
                binding.pass.setError("Password is too weak");
                binding.pass.setText("");
            } if(!name.isEmpty() &&  !phone.isEmpty() && !eid.isEmpty() && !company.isEmpty() && !emailid.isEmpty() && !password.isEmpty() ){
                firebaseAuth.createUserWithEmailAndPassword(emailid, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {@Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        String name = binding.name.getText().toString();
                        String phone = binding.mobile.getText().toString();
                        String eid=binding.eid.getText().toString();
                        String company = binding.company.getText().toString();

                        String email = binding.email.getText().toString();
                        String password = binding.pass.getText().toString();
                        if (!name.isEmpty() &&  !phone.isEmpty() && !eid.isEmpty() && !company.isEmpty() && !email.isEmpty() && !password.isEmpty()  ){
                            Users user=new Users(name,phone,eid,company,email,password);
                            firebaseDatabase=FirebaseDatabase.getInstance();
                            databaseReference=firebaseDatabase.getReference("Users");
                            databaseReference.child(name).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    binding.name.setText("");
                                    binding.mobile.setText("");
                                    binding.eid.setText("");
                                    binding.company.setText("");
                                    binding.email.setText("");

                                }
                            });
                        }

                    }}
                });
            }
        }


}