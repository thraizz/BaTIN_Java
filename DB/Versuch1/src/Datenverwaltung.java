import com.sun.xml.internal.bind.v2.TODO;

import java.io.*;
import java.util.ArrayList;

public class Datenverwaltung {
    private ArrayList<Artikel> artListe = new ArrayList<Artikel>();
    private ArrayList<Index> indexListe = new ArrayList<Index>();
    private String artikel;


    public Datenverwaltung() throws IOException {
        // Initialize indexListe with Index Objects from artikel.idx
        FileReader indexFileReader = new FileReader("artikel.idx");
        BufferedReader indexBuffer = new BufferedReader(indexFileReader);
        while(indexBuffer.readLine() != null){
            Index i = new Index(Integer.parseInt(indexBuffer.readLine()), Integer.parseInt(indexBuffer.readLine()));
            this.indexListe.add(i);
        }
        indexFileReader.close();
        indexBuffer.close();

        // Read Artikel Objects from
        FileReader artikeldatFileReader = new FileReader("artikel.dat");
        BufferedReader artikeldatBuffer = new BufferedReader(artikeldatFileReader);
        this.artikel = artikeldatBuffer.readLine();
    }

    public void addArtikel(Artikel art){
        this.artListe.add(art);
        Index i = new Index(art.getArtnr(), art.getOffset());
        this.indexListe.add(i);
        this.artikel += art.getDatensatz();
        //TODO: Artikel aus String filtern und Objekte erzeugen

    }

    public int safeExit() throws  IOException{
        FileWriter out;
        BufferedWriter bufout;

        try {
            out = new FileWriter("artikel.idx");
            bufout = new BufferedWriter(out);
            for(Index i : this.indexListe) {
                bufout.append(i.getLine());
            }
        }
        catch (IOException e){
            System.out.println(e);
            return -1;
        }
        try {
            out = new FileWriter("artikel.dat");
            bufout = new BufferedWriter(out);
            bufout.write(this.artikel);
        }
        catch (IOException e){
            System.out.println(e);
            return -1;
        }
        bufout.close();
        out.close();
        return 0;
    }

    public ArrayList<String> getAllArtikel(){
        ArrayList<String> s = new ArrayList<String>();
        for(Artikel a : artListe) {
            s.add(a.getDatensatz());
        }
        return s;
    }

    public String getArtikel(int artNr){
        for(Artikel a : this.artListe) {
            if(a.getArtnr()==artNr){
                return a.getDatensatz();
            }
        }
        return "Error! Artikel nicht gefunden";

    }
}
