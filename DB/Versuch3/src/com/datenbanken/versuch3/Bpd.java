package com.datenbanken.versuch3;

class Bpd {
    private int bstnr;
    private int ttyp;
    private int artnr;
    private String artbez;
    private int anzbo;
    private int menge;
    private int algrad;
    private boolean verpackt;

    public Bpd(int bstnr, String ttyp, int artnr, String artbez, int anzbo, int menge, boolean verpackt) {
        this.bstnr = bstnr;
        switch(ttyp){
            case "FW":
                this.ttyp = 10;
            case "WP":
                this.ttyp = 7;
            case "FR":
                this.ttyp = 5;
            case "OR":
                this.ttyp = 2;
        }
        this.artnr = artnr;
        this.artbez = artbez;
        this.anzbo = anzbo;
        this.menge = menge;
        this.algrad = (menge * 100) / anzbo +1;
        this.verpackt = verpackt;
    }

    public int getAlgrad() {
        return algrad;
    }

    public int getTtyp() { return ttyp; }

    public void setVerpackt(boolean b) {
        this.verpackt = b;
    }

    public String getArtbez() {
        return this.artbez;
    }

    @Override
    public String toString() {
        return "BPD: "+artbez+", "+algrad+".";
    }

    public void setAlgrad(int i) {
        this.algrad = i;
    }

    public int getBstnr() {
        return this.bstnr;
    }

    public int getMenge() {
        return this.menge;
    }
}