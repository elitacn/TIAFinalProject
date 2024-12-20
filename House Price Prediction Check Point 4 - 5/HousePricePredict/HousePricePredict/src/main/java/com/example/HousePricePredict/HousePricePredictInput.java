package com.example.HousePricePredict;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HousePricePredictInput {
    @JsonProperty("LB")
    private int LB; // Luas Bangunan

    @JsonProperty("LT")
    private int LT; // Luas Tanah

    @JsonProperty("KT")
    private int KT; // Jumlah Kamar Tidur

    @JsonProperty("KM")
    private int KM; // Jumlah Kamar Mandi

    @JsonProperty("GRS")
    private int GRS; // Jumlah Garasi

    // Getters and Setters
    public int getLB() {
        return LB;
    }

    public void setLB(int LB) {
        this.LB = LB;
    }

    public int getLT() {
        return LT;
    }

    public void setLT(int LT) {
        this.LT = LT;
    }

    public int getKT() {
        return KT;
    }

    public void setKT(int KT) {
        this.KT = KT;
    }

    public int getKM() {
        return KM;
    }

    public void setKM(int KM) {
        this.KM = KM;
    }

    public int getGRS() {
        return GRS;
    }

    public void setGRS(int GRS) {
        this.GRS = GRS;
    }
}