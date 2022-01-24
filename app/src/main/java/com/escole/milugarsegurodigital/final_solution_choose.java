package com.escole.milugarsegurodigital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class final_solution_choose extends AppCompatActivity {
    private ImageView icon;
    private ImageView nameImg;
    private ImageView record_btn;
    private Button fin;
    private ImageView crh;
    private EditText mi_solucion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_solution_choose);
        getSupportActionBar().hide();
        Handler handler = new Handler();
        icon = (ImageView) findViewById(R.id.final_img);
        nameImg = (ImageView) findViewById(R.id.final_desc);
        record_btn = (ImageView) findViewById(R.id.grabar);
        fin = (Button) findViewById(R.id.finalizar_btn);
        mi_solucion = (EditText) findViewById(R.id.que_solucion);
        crh = (ImageView) findViewById(R.id.final_character);
        final View vicon = icon;
        final View vfin = fin;
        final View vname = nameImg;
        final View vchr  = crh;
        intentExtras();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                TranslateAnimation animation = new TranslateAnimation(0,-vname.getWidth()-90,0,0);
                animation.setDuration(500);
                TranslateAnimation animation2 = new TranslateAnimation(0,-vchr.getWidth(),0,0);
                animation2.setDuration(500);
                animation.setFillAfter(true);
                vname.startAnimation(animation);
                vname.setVisibility(View.GONE);
                vchr.startAnimation(animation2);
                vfin.setVisibility(View.VISIBLE);
                /*nameImg.setVisibility(View.GONE);*/

            }
        },2000);



    }

    private void intentExtras(){
        if(getIntent().hasExtra("name")){
            int name = getIntent().getIntExtra("name",0);
            switch (name) {
                case 0:
                    icon.setImageResource(R.mipmap.img_cuentale_a_papamdpi);
                    nameImg.setImageResource(R.mipmap.en_compania_de_un_adultomdpi);
                    break;

                case 1:
                    icon.setImageResource(R.mipmap.materialesmdpi);
                    nameImg.setImageResource(R.mipmap.usa_tus_materialesmdpi);
                    break;
                case 2:
                    icon.setImageResource(R.mipmap.esucha_musicamdpi);
                    nameImg.setImageResource(R.mipmap.usa_tus_audifonosmdpi);
                    break;
                case 3:
                    icon.setImageResource(R.mipmap.jugar_platilinamdpi);
                    nameImg.setImageResource(R.mipmap.juega_plastilinamdpi);
                    break;
                case 4:
                    icon.setImageResource(R.mipmap.sacudetemdpi);
                    nameImg.setImageResource(R.mipmap.sacudete_txtmdpi);
                    break;
                case 5:
                    icon.setImageResource(R.mipmap.elige_otra_solucionmdpi);
                    nameImg.setImageResource(R.mipmap.eloge_tu_forma_expresarmdpi);
                    break;

            }
        }

    }
}
