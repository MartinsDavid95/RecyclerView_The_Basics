package com.example.recyclerviewthebasics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvVertical,rvHorizontal;
    private String[] interns, descriptions;
    int[] avatars = {
            R.drawable.stagiaire_01,
            R.drawable.stagiaire_02,
            R.drawable.stagiaire_03,
            R.drawable.stagiaire_04,
            R.drawable.stagiaire_05,
            R.drawable.stagiaire_06,
            R.drawable.stagiaire_07,
            R.drawable.stagiaire_08,
            R.drawable.stagiaire_09,
            R.drawable.stagiaire_10,
            R.drawable.stagiaire_11,
            R.drawable.stagiaire_12,
            R.drawable.stagiaire_13,
            R.drawable.stagiaire_14,
    };

    public void init(){
        rvHorizontal = findViewById(R.id.rv_horizontal);
        rvVertical = findViewById(R.id.rv_vertical);
        interns = getResources().getStringArray(R.array.interns);
        descriptions = getResources().getStringArray(R.array.descriptions);
    }
    private void fillRecyclerVertical(){
        MyRecyclerVerticalAdapter adapter = new MyRecyclerVerticalAdapter(this,interns,descriptions,avatars);
        rvVertical.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvVertical.setLayoutManager(linearLayoutManager);
    }
    private void fillRecyclerHorizontal(){
        MyRecyclerHorizontalAdapter adapter = new MyRecyclerHorizontalAdapter(this,interns,avatars);
        rvHorizontal.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rvHorizontal.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        fillRecyclerHorizontal();
        fillRecyclerVertical();
    }
}