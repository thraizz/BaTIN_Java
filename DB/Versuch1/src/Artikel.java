import java.io.Serializable;

public class Artikel {
    private int artnr;
    private String artbez;
    private String mge;
    private float preis;
    private float steu;
    private String s;

    public Artikel(int artnr, String artbez, String mge, float preis, float steu){
        this.artnr = artnr;
        this.artbez = artbez;
        this.mge = mge;
        this.preis = preis;
        this.steu = steu;
        this.s = artnr+";"+artbez+";"+mge+";"+preis+";"+steu+";\n";
    }

    public int getArtnr(){
        return this.artnr;
    }

    public String getDatensatz(){
        return this.s;
    }
}
