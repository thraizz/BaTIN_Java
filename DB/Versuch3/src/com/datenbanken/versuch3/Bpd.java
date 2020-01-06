package com.datenbanken.versuch3;

class Bpd{
    private int bstnr;
    private String ttyp;
    private int artnr;
    private String artbez;
    private int anzbo;
    private int menge;
    private int algrad;
    private boolean verpackt;

    public Bpd(int bstnr, String ttyp, int artnr, String artbez, int anzbo, int menge, boolean verpackt) {
        this.bstnr = bstnr;
        this.ttyp = "OR";
        this.artnr = artnr;
        this.artbez = artbez;
        this.anzbo = anzbo;
        this.menge = menge;
        this.algrad = (menge*100)/anzbo+1;
        this.verpackt = verpackt;
    }

    public int getAlgrad() {
        return algrad;
    }
}