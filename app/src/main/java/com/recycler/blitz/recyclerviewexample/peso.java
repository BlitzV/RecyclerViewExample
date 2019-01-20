package com.recycler.blitz.recyclerviewexample;

public class peso {
    private String mfecha;
    private String mpeso;

    public peso(String mfecha, String mpeso) {
        this.mfecha = mfecha;
        this.mpeso = mpeso;
    }

    public String getMfecha() {
        return mfecha;
    }

    public void setMfecha(String mfecha) {
        this.mfecha = mfecha;
    }

    public String getMpeso() {
        return mpeso;
    }

    public void setMpeso(String mpeso) {
        this.mpeso = mpeso;
    }
}
