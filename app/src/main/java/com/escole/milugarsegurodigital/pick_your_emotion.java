package com.escole.milugarsegurodigital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.escole.milugarsegurodigital.models.emotion;
import com.escole.milugarsegurodigital.recyclers.emotionReciclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class pick_your_emotion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_your_emotion);

        getSupportActionBar().hide();
        RecyclerView recyclerView = findViewById(R.id.caritas);
        recyclerView.addItemDecoration(new SimpleItemDecoration(this));
        List<emotion> posts = returnListEmotions();
        emotionReciclerViewAdapter adapter = new emotionReciclerViewAdapter(this,posts);
        recyclerView.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);

    }

    private List<emotion> returnListEmotions(){
        List<emotion> emotions = new ArrayList<>();
                emotions.add(new emotion( R.mipmap.enojadomdpi,"Enojado"));
                emotions.add(new emotion( R.mipmap.asustadomdpi,"Asustado"));
                emotions.add(new emotion( R.mipmap.tristemdpi,"Triste"));
                emotions.add(new emotion( R.mipmap.felizmdpi,"Feliz"));
                emotions.add(new emotion( R.mipmap.frustradomdpi,"Frustrado"));
                emotions.add(new emotion( R.mipmap.ansiosomdpi,"Ansioso"));
                emotions.add(new emotion( R.mipmap.decepcionadomdpi,"Decepcionado"));
                emotions.add(new emotion( R.mipmap.tranquilomdpi,"Tranquilo"));


        return emotions;
    }
}
