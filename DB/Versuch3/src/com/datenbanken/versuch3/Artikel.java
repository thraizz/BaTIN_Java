package com.datenbanken.versuch3;
public class Artikel {
    private int artnr;
    private String artbez;
    private String mge;
    private float preis;
    private float steu;
    private String s;

    public Artikel() {
    }

    public Artikel(int artnr, String artbez, String mge, float preis, float steu) {
        this.artnr = artnr;
        this.artbez = artbez;
        this.mge = mge;
        this.preis = preis;
        this.steu = steu;
        this.s = "'" + artbez + "','" + mge + "','" + preis + "','" + steu + "'";
    }

    public int getArtnr() {
        return this.artnr;
    }

    public String getInsert() {
        return "'" + artbez + "','" + mge + "','" + preis + "','" + steu + "'";
    }
}
