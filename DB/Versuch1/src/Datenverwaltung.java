import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Datenverwaltung {
    private ArrayList<Artikel> artListe = new ArrayList<Artikel>();
    private ArrayList<Index> indexListe = new ArrayList<Index>();
    private String a;
    private RandomAccessFile index;
    private RandomAccessFile artikelFile;


    public Datenverwaltung() throws IOException {
        // Initialize indexListe with Index Objects from artikel.idx
        this.index = new RandomAccessFile("artikel.idx", "rw");
        String s;
        String[] sArray;
        while((s = this.index.readLine()) != null){
            sArray = s.split(",");
            Index i = new Index(Integer.parseInt(sArray[0]), Integer.parseInt(sArray[1]));
            this.indexListe.add(i);
        }

        // Read Artikel Objects from
        artikelFile = new RandomAccessFile("artikel.dat", "rw");
        while((s = this.artikelFile.readLine()) != null){
            sArray = s.split(";");
            Artikel art = new Artikel(Integer.parseInt(sArray[0]), sArray[1], sArray[2], Float.parseFloat(sArray[3]), Float.parseFloat(sArray[4]));
            this.artListe.add(art);
        }
    }

    public void addArtikel(Artikel art) throws IOException {
        this.artListe.add(art);
        Index i = new Index(art.getArtnr(), (int)this.artikelFile.length());
        this.indexListe.add(i);
        this.a += art.getDatensatz();
        Collections.sort(this.indexListe);
        this.artikelFile.setLength(0);
        for(Artikel a : this.artListe){
            this.artikelFile.writeBytes(a.getDatensatz());
        }
    }

    public void save() throws IOException{
        this.index.setLength(0);
        for(Index i : this.indexListe) {
            this.index.writeBytes(i.getLine());
        }
    }
    public ArrayList<String> getAllIndex(){
        ArrayList<String> s = new ArrayList<String>();
        for(Index i : indexListe) {
            s.add(i.getLine());
        }
        return s;
    }

    public ArrayList<String> getAllArtikel(){
        ArrayList<String> s = new ArrayList<String>();
        for(Artikel a : artListe) {
            s.add(a.getDatensatz());
        }
        return s;
    }

    public String getArtikel(int artNr) throws IOException {
        int offset = -1;
        for(Index i : this.indexListe) {
            if(i.getArtnr()==artNr){
                offset = i.getOffset();
            }
        }
        if(offset != -1){
            this.artikelFile.seek(offset);
            return this.artikelFile.readLine();
        }
        return "Error! Artikel nicht gefunden";

    }
}
