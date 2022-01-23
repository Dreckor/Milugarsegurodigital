package com.escole.milugarsegurodigital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class describe extends AppCompatActivity {
    private ImageView img;
    private TextView emotion;
    private ImageView back;
    private ImageView next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_describe);

        getSupportActionBar().hide();

        img = (ImageView) findViewById(R.id.img);
        emotion = (TextView) findViewById(R.id.emotion);
        next = (ImageView) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),solutions.class);
                startActivity(intent);
            }
        });
        intentExtras();
    }
    private void intentExtras() {
        if (getIntent().hasExtra("image")) {
            String textemotion = getIntent().getStringExtra("emotion");
            int image = getIntent().getIntExtra("image", R.mipmap.enojadomdpi);

            img.setImageResource(image);
            emotion.setText(textemotion);

        }
    }
}
