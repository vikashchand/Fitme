package com.example.fitme;




import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class Log extends AppCompatActivity {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fitme-61160-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        final EditText un = findViewById(R.id.username);
        final EditText p = findViewById(R.id.password);
        final TextView registernow = findViewById(R.id.RegNow);
        final Button loginbtn = findViewById(R.id.loginButton);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String untxt = un.getText().toString();
                final String psdtxt = p.getText().toString();
                if(untxt.isEmpty() || psdtxt.isEmpty()){
                    Toast.makeText(Log.this,"Please enter your username and password",Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(untxt)){
                                final String getpswd = snapshot.child(untxt).child("password").getValue(String.class);
                                if(getpswd.equals(psdtxt)){
                                    startActivity(new Intent(Log.this,MainActivity.class));
                                    finish();
                                }
                                else{
                                    Toast.makeText(Log.this, "Please check the password", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(Log.this, "Please check the username", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });
        registernow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Log.this,Register.class));
            }
        });

    }
}