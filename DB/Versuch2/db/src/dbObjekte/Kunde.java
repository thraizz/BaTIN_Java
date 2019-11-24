package dbObjekte;

public class Kunde {
    private int knr;
    private String kname;
    private int plz;
    private String ort;
    private String strasse;

    public Kunde(int knr, String kname, int plz, String ort, String strasse) {
        this.knr = knr;
        this.kname = kname;
        this.plz = plz;
        this.ort = ort;
        this.strasse = strasse;
    }

    public String getFormattedAttributes() {
        return "KNR " + this.knr + "\n" +
                this.kname + "\n" +
                this.plz + " " + this.ort + "\n" +
                this.strasse + "\n";
    }

    public String getValues() {
        return "'" + this.kname + "','" + this.plz + "','" + this.ort + "','" + this.strasse + "'";
    }

    public String getColNames() {
        return "KNAME,PLZ,ORT,STRASSE";
    }
}


