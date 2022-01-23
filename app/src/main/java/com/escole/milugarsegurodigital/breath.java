package com.escole.milugarsegurodigital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Timer;
import java.util.TimerTask;

public class breath extends AppCompatActivity {

    private ImageView imgView;
    private int img;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breath);
        getSupportActionBar().hide();

        imgView = findViewById(R.id.activityImg);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), select_activity.class);
                startActivity(intent);
            }
        });
        intentExtras();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), how_do_you_feel.class);
                startActivity(intent);
            }
        },2000);

    }
    private void intentExtras() {
        if (getIntent().hasExtra("image")) {
            int image = getIntent().getIntExtra("image", R.mipmap.recurso_14mdpi);
            imgView.setImageResource(image);

        }
    }
}
