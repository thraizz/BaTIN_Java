package com.datenbanken.versuch3;

public class Box {
    public int vbnr;
    public int vbtyp;
    public int R;

    public Box(int vbnr, String vbtyp){
        this.vbnr = vbnr;
        switch(vbtyp){
            case "FW":
                this.vbtyp = 10;
            case "WP":
                this.vbtyp = 7;
            case "FR":
                this.vbtyp = 5;
            case "OR":
                this.vbtyp = 2;
        }
        this.R = 100;
    }
}
