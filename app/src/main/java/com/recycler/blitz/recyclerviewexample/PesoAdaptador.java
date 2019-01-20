package com.recycler.blitz.recyclerviewexample;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PesoAdaptador extends RecyclerView.Adapter<PesoAdaptador.PesoViewHolder>{

    private List<peso> pesos;
    public PesoAdaptador (List<peso> pesos){
        this.pesos = pesos;
    }

    @NonNull
    @Override
    public PesoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new PesoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PesoViewHolder pesoViewHolder, int i) {
        peso Peso = pesos.get(i);
        pesoViewHolder.textView1.setText(Peso.getMfecha());
        pesoViewHolder.textView2.setText(Peso.getMpeso());
        double diferencia;
        String diferenciaString;
        if(i!=0){
            peso pesoMenosUno = pesos.get(i-1);
            diferencia = Double.parseDouble(Peso.getMpeso())-Double.parseDouble(pesoMenosUno.getMpeso());
            diferenciaString = String.valueOf(diferencia);
        }else{
            diferencia=0;
            diferenciaString="0";
        }
        pesoViewHolder.textView3.setText(diferenciaString);
        if(diferencia>0){
            pesoViewHolder.textView3.setTextColor(Color.parseColor("#64DD17"));
        }else if(diferencia==0){
            pesoViewHolder.textView3.setTextColor(Color.parseColor("#000000"));
        }else{
            pesoViewHolder.textView3.setTextColor(Color.parseColor("#D50000"));
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PesoViewHolder extends RecyclerView.ViewHolder{
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;

        public PesoViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = (TextView) itemView.findViewById(R.id.tvFecha);
            textView2 = (TextView) itemView.findViewById(R.id.tvPeso);
            textView3 = (TextView) itemView.findViewById(R.id.tvDiferencia);
        }
    }
}
