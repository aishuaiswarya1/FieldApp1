package com.example.fieldaware;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.fieldaware.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    FirebaseAuth firebaseAuth;
    String name, eid, phone, company, email, password;

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[@#$%^&+=])" +
                    "(?=\\S+$)" +
                    ".{4,}" +
                    "$");

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater(), null, false);
        setContentView(binding.getRoot());
        firebaseAuth = FirebaseAuth.getInstance();


            binding.register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), Registration.class));
                }
            });

            binding.b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    loginuser();

                }

                private void loginuser() {
                    String emailid = binding.e1.getEditText().getText().toString().trim();
                    String pass = binding.e2.getEditText().getText().toString().trim();
                    if (emailid.isEmpty()) {
                        binding.e1.setError("Field can not be empty");
                    } else if (!Patterns.EMAIL_ADDRESS.matcher(emailid).matches()) {
                        binding.e1.setError("Please enter a valid email address");
                    } else if (pass.isEmpty()) {
                        binding.e2.setError("Field can not be empty");
                    } else if (!PASSWORD_PATTERN.matcher(pass).matches()) {
                        binding.e2.setError("Password is too weak");
                    } else
                        firebaseAuth.signInWithEmailAndPassword(emailid, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(getApplicationContext(), datetime.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(MainActivity.this, "Please register first", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                }
            });
        }
    }



