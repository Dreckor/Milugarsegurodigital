package com.escole.milugarsegurodigital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class before_start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_start);
        getSupportActionBar().hide();
    }
    public void selectActivity(View view){
        Intent intent = new Intent(this,select_activity.class);
        startActivity(intent);
    }
}
