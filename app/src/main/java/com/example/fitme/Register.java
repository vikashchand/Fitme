package com.example.fitme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {
    //create a databasereference class to access firebase's realtime database
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fitme-61160-default-rtdb.firebaseio.com/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText fn = findViewById(R.id.name);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) final EditText regnum = findViewById(R.id.rn);
        final EditText vm = findViewById(R.id.mail);
        final EditText pn = findViewById(R.id.phno);
        final EditText pd = findViewById(R.id.password);
        final EditText cpd = findViewById(R.id.cnfpswd);
        final Button regbtn = findViewById(R.id.RegisterButton);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) final TextView loginNow = findViewById(R.id.loginnow);

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String fntxt = fn.getText().toString();
                final String regnumtxt = regnum.getText().toString();
                final String vmtxt = vm.getText().toString();
                final String pntxt = pn.getText().toString();
                final String pdtxt = pd.getText().toString();
                final String cpdtxt = cpd.getText().toString();
                if(fntxt.isEmpty()||regnumtxt.isEmpty()||vmtxt.isEmpty()||pntxt.isEmpty()||pdtxt.isEmpty()||cpdtxt.isEmpty()){
                    Toast.makeText(Register.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else if(!pdtxt.equals(cpdtxt)){
                    Toast.makeText(Register.this, "Please makesure that Password and Confirm Password matches", Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //check if reg num is already registered.
                            if(snapshot.hasChild(regnumtxt)){
                                Toast.makeText(Register.this, "User already exists", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                databaseReference.child("users").child(regnumtxt).child("fullname").setValue(fntxt);
                                databaseReference.child("users").child(regnumtxt).child("mail id").setValue(vmtxt);
                                databaseReference.child("users").child(regnumtxt).child("phone").setValue(pntxt);
                                databaseReference.child("users").child(regnumtxt).child("password").setValue(pdtxt);
                                Toast.makeText(Register.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }

            }
        });
        loginNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });


    }
}