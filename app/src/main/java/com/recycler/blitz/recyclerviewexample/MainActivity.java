package com.recycler.blitz.recyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<peso> pesos;
    private RecyclerView recyclerView;
    private PesoAdaptador pesoAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager ln = new LinearLayoutManager(this);
        ln.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(ln);

        data();
        initializeAdapter();
    }

    private void initializeAdapter() {
        pesoAdaptador = new PesoAdaptador(pesos);
        recyclerView.setAdapter(pesoAdaptador);
    }

    private void data() {
        pesos = new ArrayList<>();
        pesos.add(new peso("24/4/1232","43"));
        pesos.add(new peso("24/4/1232","43"));
        pesos.add(new peso("24/4/1232","49"));
        pesos.add(new peso("24/4/2900","46"));
        pesos.add(new peso("24/4/1232","43"));
        pesos.add(new peso("24/4/1232","42"));
        pesos.add(new peso("24/4/1232","43"));
        pesos.add(new peso("24/4/2932","43"));
        pesos.add(new peso("24/4/1232","43"));
        pesos.add(new peso("24/4/1232","45"));
        pesos.add(new peso("24/4/1232","43"));
        pesos.add(new peso("24/4/1232","43"));
        pesos.add(new peso("24/4/1232","49"));
        pesos.add(new peso("24/4/1232","43"));
        pesos.add(new peso("24/4/1232","43"));
        pesos.add(new peso("24/4/1232","43"));
        pesos.add(new peso("24/4/1232","43"));
    }
}
