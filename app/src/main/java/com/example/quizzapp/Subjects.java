package com.example.quizzapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Subjects extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);

        recyclerView = findViewById(R.id.idCourseRV);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        myAdapter = new MyAdapter(this, getMyList());
        recyclerView.setAdapter(myAdapter);

    }

    @NonNull
    private ArrayList<Model> getMyList() {
        ArrayList<Model> models = new ArrayList<>();
        Model m = new Model();

        m.setId(1);
        m = new Model();
        m.setPath(CalculusQuestions.class);
        m.setTitle("Calculus");
        m.setImg(R.drawable.calculus);
        models.add(m);

        m.setId(2);
        m = new Model();
        m.setPath(ArtificialIntelligenece.class);
        m.setTitle("Artificial Intelligence");
        m.setImg(R.drawable.artificial_intelligence);
        models.add(m);

        m.setId(3);
        m = new Model();
        m.setPath(MachineLearning.class);
        m.setTitle("Machine Learning");
        m.setImg(R.drawable.machine_learning);
        models.add(m);

        m.setId(4);
        m = new Model();
        m.setPath(Networking.class);
        m.setTitle("Networking");
        m.setImg(R.drawable.networking);
        models.add(m);

        m.setId(5);
        m = new Model();
        m.setPath(SoftwareEngineering.class);
        m.setTitle("Software Engineering");
        m.setImg(R.drawable.softareengineering);
        models.add(m);

        m.setId(6);
        m = new Model();
        m.setPath(EnglishLanguage.class);
        m.setTitle("English Language");
        m.setImg(R.drawable.english);
        models.add(m);

        m.setId(1);
        return models;
    }
}