package com.samet.kentsimgelerikitab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.samet.kentsimgelerikitab.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    ArrayList<Landmark> landmarksList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        landmarksList = new ArrayList<>();

        Landmark pisa = new Landmark("Pisa","Italy",R.drawable.pisa);
        Landmark eiffel = new Landmark("Eiffel Tower","France",R.drawable.eifel);
        Landmark london = new Landmark("London Bridge","UK",R.drawable.london);
        Landmark colosseum = new Landmark("Colosseum","Italy",R.drawable.collesium);

        landmarksList.add(pisa);
        landmarksList.add(eiffel);
        landmarksList.add(london);
        landmarksList.add(colosseum);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        landmarkAdapter landmarkAdapter1 = new landmarkAdapter(landmarksList);
        binding.recyclerView.setAdapter(landmarkAdapter1);


    }
}