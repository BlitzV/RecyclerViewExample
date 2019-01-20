package com.recycler.blitz.recyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.recycler.blitz.recyclerviewexample.PesoAdaptador.FECHA;
import static com.recycler.blitz.recyclerviewexample.PesoAdaptador.PESO;

public class ActivityEdit extends AppCompatActivity {

    private String peso;
    private String fecha;

    private TextView tx1;
    private TextView tx2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        peso = getIntent().getStringExtra(PESO);
        fecha = getIntent().getStringExtra(FECHA);

        tx1 = (TextView) findViewById(R.id.text1);
        tx1.setText(peso);
        tx2 = (TextView) findViewById(R.id.text2);
        tx2.setText(fecha);
    }
}
