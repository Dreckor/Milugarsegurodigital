package com.escole.milugarsegurodigital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.escole.milugarsegurodigital.models.activity;

import java.util.ArrayList;
import java.util.List;

public class select_activity extends AppCompatActivity {

    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_activity);
        getSupportActionBar().hide();
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.addItemDecoration(new SimpleItemDecoration(this));
        List<activity> posts = returnListItems();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, posts);
        recyclerView.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        back   = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), before_start.class);
                startActivity(intent);
            }
        });

    }


    private List<activity> returnListItems() {
        List<activity> items = new ArrayList<>();
        items.add(new activity("S.T.A.R", "Sonríe, respira profundamente y relájate. Infla tu estómago cuando entre el aire, y desinflalo cuando salga el aire. \n" +
                "Para el cuidador: Ayuda también a los niños a aprender a exhalar más despacio de lo que inhalan.", R.mipmap.recurso_14mdpi));
        items.add(new activity("Drain", "Extiende los brazos hacia fuera, simulando que tus brazos son grifos. Aprieta los músculos de tus brazos, de tus hombros y de tu cara. Exhala lentamente haciendo un sonido \"sssshhh\" (simulando a una llave) y suelta todos los músculos, sintiendo como te lleva a un momento de relajación.", R.mipmap.recurso_15mdpi));
        items.add(new activity("Ballon", "Coloca las manos sobre la cabeza y entrelaza los dedos. Mientras el aire entra por tu nariz, ve levantando tus brazos, tal como si estuvieras inflando un globo imaginario. Suelta el aire del globo, exhala lentamente, baja los brazos y haz el sonido que escuchas cuando se desinfla un globo (prrrprrpr).", R.mipmap.recurso_16mdpi));
        items.add(new activity("Pretzel", "De pie, cruza los tobillos. Ahora cruza la muñeca derecha sobre la izquierda, gira las manos de forma que los pulgares queden mirando al suelo, junta las palmas y entrelaza los dedos. Dobla los codos hacia fuera y gira suavemente las manos hacia abajo y hacia el cuerpo hasta que se apoyen en el centro del pecho. Relájate y respira profundo tres veces.", R.mipmap.recurso_17mdpi));

        return items;
    }
}

