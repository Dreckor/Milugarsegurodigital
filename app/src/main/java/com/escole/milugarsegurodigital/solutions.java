package com.escole.milugarsegurodigital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.escole.milugarsegurodigital.models.solution;
import com.escole.milugarsegurodigital.recyclers.solutionRecycler;

import java.util.ArrayList;
import java.util.List;

public class solutions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solutions);
        getSupportActionBar().hide();

        RecyclerView recyclerView = findViewById(R.id.solutions);
        recyclerView.addItemDecoration(new SimpleItemDecoration(this));
        List<solution> posts = returnSolutions();
        solutionRecycler adapter = new solutionRecycler(this, posts);
        recyclerView.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
    }

    private List<solution> returnSolutions(){
        List<solution> solutions = new ArrayList<>();
        solutions.add(new solution(R.mipmap.comentale_a_papamdpi,"Coméntale a tu mamá o papá cómo te sientes"));
        solutions.add(new solution(R.mipmap.dibujar_escribirmdpi,"Dibujar o escribir y respirar"));
        solutions.add(new solution(R.mipmap.escucha_tu_musica_favmdpi,"Escuchar tu música favorita"));
        solutions.add(new solution(R.mipmap.jugar_con_plastilinamdpi,"Jugar con plastilina"));
        solutions.add(new solution(R.mipmap.bailarmdpi,"Bailar"));
        solutions.add(new solution(R.mipmap.otromdpi,"Otro"));

        return solutions;
    }
}
