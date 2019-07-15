package com.example.shyammittal.practiceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SecondActivity extends AppCompatActivity {

    Button btn1;
    TextView tvPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btn1 = findViewById(R.id.bt_signOut);
        tvPhoneNumber = findViewById(R.id.tv_phoneNumber);
        setPhoneNumber();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(SecondActivity.this,MainActivity.class));
                finish();
            }
        });

    }
    private void setPhoneNumber(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        try{
            tvPhoneNumber.setText(user.getPhoneNumber());
        }
        catch (Exception e){
            Toast.makeText(this,"Phone Number not found",Toast.LENGTH_SHORT).show();
        }
    }

}
