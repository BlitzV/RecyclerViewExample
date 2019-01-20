package com.recycler.blitz.recyclerviewexample;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
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

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(createherlpercallback());
        itemTouchHelper.attachToRecyclerView(recyclerView);

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

    private ItemTouchHelper.Callback createherlpercallback() {
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                moveItem(viewHolder.getAdapterPosition(), viewHolder1.getAdapterPosition());
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                deleteItem(viewHolder.getAdapterPosition());
            }
        };
        return simpleCallback;
    }

    private void deleteItem(final int position) {
        pesos.remove(position);
        pesoAdaptador.notifyItemRemoved(position);
    }

    private void moveItem(int oldPosition, int newPos){
        peso item = (peso) pesos.get(oldPosition);
        pesos.remove(oldPosition);
        pesos.add(newPos, item);
        pesoAdaptador.notifyItemMoved(oldPosition,newPos);
    }
}
